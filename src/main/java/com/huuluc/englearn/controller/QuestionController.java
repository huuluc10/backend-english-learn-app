package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Question", description = "Question API")
@RequestMapping("/api/v1/question")
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("/findById")
    @Operation(summary = "Find question by id")
    public List<Question> findById(short questionId) {
        return questionService.findById(questionId);
    }

    @GetMapping("/findByLessonId")
    @Operation(summary = "Find question by lesson id")
    public List<Question> findByLessonId(short lessonId) {
        return questionService.findByLessonId(lessonId);
    }

    @GetMapping("/findByExamId")
    @Operation(summary = "Find question by exam id")
    public ResponseEntity<ResponseModel> findByExamId(short examId) throws QuestionException {
        return questionService.findByExamId(examId);
    }
}
