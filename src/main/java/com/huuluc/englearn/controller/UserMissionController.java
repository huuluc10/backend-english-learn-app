package com.huuluc.englearn.controller;

import com.huuluc.englearn.entity.UserMission;
import com.huuluc.englearn.service.UserMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user-mission")
public class UserMissionController {
    private final UserMissionService userMissionService;

    @GetMapping("/")
    public List<UserMission> getByUserId(@RequestParam int userId) {
        return userMissionService.getByUserId(userId);
    }

    @PostMapping("/")
    public int add(@RequestParam String username, @RequestParam short missionId) {
        return userMissionService.add(username, missionId);
    }
}