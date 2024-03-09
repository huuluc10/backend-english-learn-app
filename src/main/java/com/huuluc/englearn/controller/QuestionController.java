package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Tag(name = "Question", description = "Question API")
@RequestMapping("/api/v1/question")
@Slf4j
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("/findById")
    @Operation(summary = "Find question by id")
    public ResponseEntity<ResponseModel> findById(short questionId) throws QuestionException {
        log.info("Find question by id: {}", questionId);
        return questionService.findById(questionId);
    }

    @GetMapping("/findByLessonId")
    @Operation(summary = "Find question by lesson id")
    public ResponseEntity<ResponseModel> findByLessonId(short lessonId) throws QuestionException {
        log.info("Find question by lesson id: {}", lessonId);
        return questionService.findByLessonId(lessonId);
    }

    @GetMapping("/findByExamId")
    @Operation(summary = "Find question by exam id")
    public ResponseEntity<ResponseModel> findByExamId(short examId) throws QuestionException {
        log.info("Find question by exam id: {}", examId);
        return questionService.findByExamId(examId);
    }
}
