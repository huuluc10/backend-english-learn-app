package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.MissionDailyException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MissionDailyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/v1/manage/mission")
@Tag(name = "Admin Manage Mission", description = "Admin API Manage Mission")
@Slf4j
public class AdminManageMissionController {
    private final MissionDailyService missionDailyService;

    @GetMapping("/")
    @Operation(summary = "Get all mission dailies")
    public ResponseEntity<ResponseModel> getAll() throws MissionDailyException {
        log.info("Admin: Get all mission dailies");
        return missionDailyService.getAll();
    }
}
