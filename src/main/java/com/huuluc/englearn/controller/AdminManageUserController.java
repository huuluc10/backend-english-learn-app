package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/v1/manage/user")
@Tag(name = "Admin Manage User", description = "Admin API Manage User")
@Slf4j
public class AdminManageUserController {
    private final UserService userService;

    @GetMapping("/")
    @Operation(summary = "Get all users")
    public ResponseEntity<ResponseModel> findAll() throws UserException {
        log.info("Admin: Get all users");
        return userService.findAll();
    }

}
