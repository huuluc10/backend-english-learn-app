package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.service.LevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/v1/manage/level")
@RequiredArgsConstructor
@Tag(name = "Admin Manage Level", description = "Admin API Manage Level")
@Slf4j
public class AdminManageLevelController {
    private final LevelService levelService;

    @GetMapping("/")
    @Operation(summary = "Get list level")
    public List<Level> findAll() throws LevelException {
        log.info("Admin: Get list level");
        return levelService.findAll();
    }

    @GetMapping("/{levelId}")
    @Operation(summary = "Get level by id")
    public Level findById(@PathVariable short levelId) throws LevelException {
        log.info("Admin: Get level by id {}", levelId);
        return levelService.findById(levelId);
    }
}
