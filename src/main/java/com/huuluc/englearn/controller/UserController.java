package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User API")
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    @Operation(summary = "Create a new account")
    public ResponseEntity<ResponseModel> createAccount(@RequestBody CreateUserRequest request) throws UserException {
        return userService.createUser(request);
    }

    @PostMapping("/update")
    @Operation(summary = "Update user information")
    public ResponseEntity<ResponseModel> updateInfo(@RequestBody UpdateInfoRequest request) throws UserException {
        return userService.updateUser(request);
    }

    @PostMapping("/updateAvatar")
    @Operation(summary = "Update user avatar")
    public ResponseEntity<ResponseModel> updateAvatar(@RequestParam String username, @RequestParam("file") MultipartFile avatar) throws UserException, MediaException {
        return userService.updateAvatar(username, avatar);
    }


    @PostMapping("/getByUsername")
    @Operation(summary = "Get user information by username")
    public ResponseEntity<ResponseModel> getByUsername(@RequestParam String username) throws UserException {
        return userService.getByUsername(username);
    }

    @GetMapping("/getByEmail")
    @Operation(summary = "Get user information by email")
    public ResponseEntity<ResponseModel> getByEmail(String email) throws UserException {
        return userService.getByEmail(email);
    }
    
}
