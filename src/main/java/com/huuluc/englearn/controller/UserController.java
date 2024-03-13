package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.request.*;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MailService;
import com.huuluc.englearn.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLIntegrityConstraintViolationException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "User API")
@Slf4j
public class UserController {
    private final UserService userService;
    private final MailService mailService;

    @PostMapping("/")
    @Operation(summary = "Create a new account")
    public ResponseEntity<ResponseModel> createAccount(@RequestBody SignupRequest request) throws UserException {
        log.info("Create account by username {}", request.getUsername());
        return userService.createUser(request);
    }

    @PostMapping("/update")
    @Operation(summary = "Update user information")
    public ResponseEntity<ResponseModel> updateInfo(@RequestBody UpdateInfoRequest request) throws UserException {
        log.info("Update user information by username {}", request.getUsername());
        return userService.updateUser(request);
    }

    @PostMapping("/updateAvatar")
    @Operation(summary = "Update user avatar")
    public ResponseEntity<ResponseModel> updateAvatar(@RequestParam("file") MultipartFile avatar)
            throws UserException, MediaException {
        //get username from token and check if it is the same as the username in the request
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        log.info("Update user avatar by username {}", username);
        return userService.updateAvatar(username, avatar);
    }


    @PostMapping("/getByUsername")
    @Operation(summary = "Get user information by username")
    public ResponseEntity<ResponseModel> getByUsername()
            throws UserException, MediaException, LevelException, UserMissionException {
        //get username from token and check if it is the same as the username in the request
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        log.info("Get user information by username {}", username);
        return userService.getByUsername(username);
    }

    @PostMapping("/changePassword")
    @Operation(summary = "Change user password")
    public ResponseEntity<ResponseModel> changePassword(@RequestBody ChangePasswordRequest request)
            throws UserException, SQLIntegrityConstraintViolationException {
        log.info("Change password by username {}", request.getUsername());
        return userService.changePassword(request);
    }


    @PostMapping("/addEmail")
    @Operation(summary = "Add mail")
    public ResponseEntity<ResponseModel> addEmail(@RequestBody AddEmailRequest request) throws UserException {
        log.info("Add mail");
        return userService.addEmail(request);
    }
    @PostMapping("/resetPassword")
    @Operation(summary = "Reset password")
    public ResponseEntity<ResponseModel> resetPassword(@RequestBody ResetPasswordRequest request) throws UserException{
        log.info("Reset password");
        return userService.resetPassword(request);
    }
}
