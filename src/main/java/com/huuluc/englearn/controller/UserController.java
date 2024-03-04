package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<ResponseModel> createAccount(@RequestBody CreateUserRequest request) throws UserException {
        return userService.createUser(request);
    }

    @PostMapping("/update")
    public int updateUser(User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/delete")
    public int deleteUser(String username) {
        return userService.deleteUser(username);
    }

    @PostMapping("/getByUsername")
    public ResponseEntity<ResponseModel> getByUsername(@RequestParam String username) throws IOException {
        return userService.getByUsername(username);
    }

    @GetMapping("/getByEmail")
    public User getByEmail(String email) {
        return userService.getByEmail(email);
    }
    
}
