package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.User;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/v1/manage/user")
public class AdminManageUserController {
    private final UserService userService;

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

}
