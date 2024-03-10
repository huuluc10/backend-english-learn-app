package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.exception.UserMissionException;
import com.huuluc.englearn.model.request.ChangePasswordRequest;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/")
    @Operation(summary = "Create a new account")
    public ResponseEntity<ResponseModel> createAccount(@RequestBody CreateUserRequest request) throws UserException {
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
    public ResponseEntity<ResponseModel> updateAvatar(@RequestParam String username,
                                                      @RequestParam("file") MultipartFile avatar)
            throws UserException, MediaException {
        log.info("Update user avatar by username {}", username);
        return userService.updateAvatar(username, avatar);
    }


    @PostMapping("/getByUsername")
    @Operation(summary = "Get user information by username")
    public ResponseEntity<ResponseModel> getByUsername(@RequestParam String username)
            throws UserException, MediaException, LevelException, UserMissionException {
        log.info("Get user information by username {}", username);
        return userService.getByUsername(username);
    }

    @GetMapping("/getByEmail")
    @Operation(summary = "Get user information by email")
    public ResponseEntity<ResponseModel> getByEmail(String email) throws UserException, UserMissionException {
        log.info("Get user information by email {}", email);
        return userService.getByEmail(email);
    }

    @PostMapping("/changePassword")
    @Operation(summary = "Change user password")
    public ResponseEntity<ResponseModel> changePassword(@RequestBody ChangePasswordRequest request)
            throws UserException, SQLIntegrityConstraintViolationException {
        log.info("Change password by username {}", request.getUsername());
        return userService.changePassword(request);
    }
}
