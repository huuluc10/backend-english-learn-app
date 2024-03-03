package com.huuluc.englearn.controller;

import com.huuluc.englearn.entity.User;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public int insertUser(User user) {
        return userService.insertUser(user);
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
    public User getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/getByEmail")
    public User getByEmail(String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/getByUsernameAndPassword")
    public User getByUsernameAndPassword(String username, String password) {
        return userService.getByUsernameAndPassword(username, password);
    }
}
