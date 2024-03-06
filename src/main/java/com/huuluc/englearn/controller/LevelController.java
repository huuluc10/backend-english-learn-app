package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/level")
public class LevelController {
    private final LevelService levelService;

    @GetMapping("/")
    public List<Level> findAll() {
        return levelService.findAll();
    }

    @GetMapping("/{levelId}")
    public Level findById(@PathVariable short levelId) {
        return levelService.findById(levelId);
    }

    @GetMapping("/exp/{exp}")
    public Level findByExp(@PathVariable int exp) {
        return levelService.findByExp(exp);
    }
}
