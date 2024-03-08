package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.UserMission;
import com.huuluc.englearn.service.UserMissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user-mission")
@Tag(name = "User Mission", description = "User Mission API")
public class UserMissionController {
    private final UserMissionService userMissionService;

    @GetMapping("/")
    @Operation(summary = "Get All User Mission", description = "Get All User Mission")
    public List<UserMission> getByUserId(@RequestParam short userId) {
        return userMissionService.findByUserId(userId);
    }

}
