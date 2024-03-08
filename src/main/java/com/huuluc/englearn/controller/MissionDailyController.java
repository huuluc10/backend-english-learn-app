package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.MissionDaily;
import com.huuluc.englearn.service.MissionDailyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mission-daily")
@Tag(name = "Mission Daily", description = "Mission Daily API")
public class MissionDailyController {
    private final MissionDailyService missionDailyService;

    @GetMapping("/")
    @Operation(summary = "Get all mission dailies")
    public List<MissionDaily> getAll() {
        return missionDailyService.getAll();
    }


}
