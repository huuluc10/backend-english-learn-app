package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.User;
import com.huuluc.englearn.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/v1/manage/user")
@Tag(name = "Admin API Manage User")
public class AdminManageUserController {
    private final UserService userService;

    @GetMapping("/")
    @Operation(summary = "Get all users")
    public List<User> findAll() {
        return userService.findAll();
    }

}
