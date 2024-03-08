package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.QuestionType;
import com.huuluc.englearn.service.QuestionTypeService;
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
@RequestMapping("/api/v1/question-type")
@Tag(name = "Question Type", description = "Question Type API")
public class QuestionTypeController {
    private final QuestionTypeService questionTypeService;

    @GetMapping("/")
    @Operation(summary = "Get all question types")
    public List<QuestionType> findAll() {
        return questionTypeService.findAll();
    }

    @GetMapping("/{questionTypeId}")
    @Operation(summary = "Get question type by id")
    public QuestionType findById(@PathVariable short questionTypeId) {
        return questionTypeService.findById(questionTypeId);
    }
}
