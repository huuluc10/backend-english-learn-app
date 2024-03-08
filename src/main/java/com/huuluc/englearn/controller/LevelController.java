package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.LevelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/exp/{exp}")
    @Operation(summary = "Get level by exp")
    public ResponseEntity<ResponseModel> findByExp(@PathVariable int exp) throws LevelException {
        return levelService.findByExp(exp);
    }
}
