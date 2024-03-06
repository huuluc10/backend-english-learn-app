package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Role;
import com.huuluc.englearn.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/")
    public List<Role> getAll() {
        return roleService.getAll();
    }
}
