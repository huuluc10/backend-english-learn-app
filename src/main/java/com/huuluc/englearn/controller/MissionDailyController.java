package com.huuluc.englearn.controller;

import com.huuluc.englearn.entity.MissionDaily;
import com.huuluc.englearn.service.MissionDailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mission-daily")
public class MissionDailyController {
    private final MissionDailyService missionDailyService;

    @GetMapping("/")
    public List<MissionDaily> getAll() {
        return missionDailyService.getAll();
    }


}
