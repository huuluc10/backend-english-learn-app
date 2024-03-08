package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Role;
import com.huuluc.englearn.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/role")
@Tag(name = "Role", description = "Role API")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/")
    @Operation(summary = "Get all roles")
    public List<Role> getAll() {
        return roleService.getAll();
    }
}
