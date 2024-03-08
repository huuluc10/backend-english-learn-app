package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.service.LevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/level")
@Tag(name = "Level", description = "Level API")
public class LevelController {
    private final LevelService levelService;

    @GetMapping("/")
    @Operation(summary = "Get list level")
    public List<Level> findAll() {
        return levelService.findAll();
    }

    @GetMapping("/{levelId}")
    @Operation(summary = "Get level by id")
    public Level findById(@PathVariable short levelId) {
        return levelService.findById(levelId);
    }

    @GetMapping("/exp/{exp}")
    @Operation(summary = "Get level by exp")
    public Level findByExp(@PathVariable int exp) {
        return levelService.findByExp(exp);
    }
}
