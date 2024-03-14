package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.JwtTokenBlacklistException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.request.LoginRequest;
import com.huuluc.englearn.model.request.SignupRequest;
import com.huuluc.englearn.model.response.JwtResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.security.JwtUtils;
import com.huuluc.englearn.service.impl.UserServiceImpl;
import com.huuluc.englearn.utils.MessageStringResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
@Tag(name = "Auth", description = "Auth API")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<ResponseModel> authenticateUser(@Valid @RequestBody LoginRequest loginRequest,
                                                          HttpServletRequest request) {

        try {
            log.info("Login");
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));



            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            // Save token to session
            request.getSession().setAttribute("token", jwt);

            org.springframework.security.core.userdetails.User userDetails = (User) authentication.getPrincipal();

            // Return token to client
            JwtResponse jwtResponse = new JwtResponse(jwt,
                    userDetails);

            ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                    MessageStringResponse.LOGIN_SUCCESSFULLY, jwtResponse);
            return ResponseEntity.ok(responseModel);
        } catch (AuthenticationException e) {
            ResponseModel responseModel = new ResponseModel(MessageStringResponse.UNAUTHORIZED,
                    MessageStringResponse.INVALID_USERNAME_OR_PASSWORD, null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseModel);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseModel> registerUser(@Valid @RequestBody SignupRequest request) throws UserException {
        if (userService.existsByUsername(request.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseModel(MessageStringResponse.ERROR,
                            MessageStringResponse.USERNAME_IS_ALREADY, null));
        }

        // Encode password
        request.setPassword(encoder.encode(request.getPassword()));
        return userService.createUser(request);

    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseModel> logout(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws JwtTokenBlacklistException {
        log.info("Logout");

        // Remove authentication from SecurityContext
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.setClearAuthentication(true);
        securityContextLogoutHandler.logout(request, response, authentication);

        // Remove token from session
        request.getSession().removeAttribute("token");
        SecurityContextHolder.getContext().setAuthentication(null);
        int resultRevokeToken = jwtUtils.revokeToken(request.getHeader("Authorization").substring(7));

        // If revoke token failed
        if (resultRevokeToken == 0) {
            return ResponseEntity.badRequest().body(new ResponseModel(MessageStringResponse.ERROR,
                    MessageStringResponse.LOGOUT_FAILED, null));
        }
        return ResponseEntity.ok(new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.LOGOUT_SUCCESSFULLY, null));
    }
}
