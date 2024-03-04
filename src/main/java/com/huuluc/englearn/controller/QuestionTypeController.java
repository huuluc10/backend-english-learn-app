package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.QuestionType;
import com.huuluc.englearn.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question-type")
public class QuestionTypeController {
    private final QuestionTypeService questionTypeService;

    @GetMapping("/")
    public List<QuestionType> findAll() {
        return questionTypeService.findAll();
    }

    @GetMapping("/{questionTypeId}")
    public QuestionType findById(@PathVariable short questionTypeId) {
        return questionTypeService.findById(questionTypeId);
    }
}
