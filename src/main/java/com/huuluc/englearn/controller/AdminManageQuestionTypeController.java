package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.QuestionTypeException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.QuestionTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/manage/question-type")
@Tag(name = "Question Type", description = "Question Type API")
@Slf4j
public class AdminManageQuestionTypeController {
    private final QuestionTypeService questionTypeService;

    @GetMapping("/")
    @Operation(summary = "Get all question types")
    public ResponseEntity<ResponseModel> findAll() throws QuestionTypeException {
        log.info("Admin: Get all question types");
        return questionTypeService.findAll();
    }

    @GetMapping("/{questionTypeId}")
    @Operation(summary = "Get question type by id")
    public ResponseEntity<ResponseModel> findById(@PathVariable short questionTypeId) throws QuestionTypeException {
        log.info("Admin: Get question type by id: {}", questionTypeId);
        return questionTypeService.findById(questionTypeId);
    }
}
