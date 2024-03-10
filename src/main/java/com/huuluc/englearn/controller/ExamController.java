package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.ExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exam")
@Tag(name = "Exam", description = "Exam API")
@Slf4j
public class ExamController {
    private final ExamService examService;

    @GetMapping("/")
    @Operation(summary = "Get all exams by topic")
    public ResponseEntity<ResponseModel> getAllExamsByTopic(@RequestParam String username, @RequestParam short topicId) throws ExamException, LevelException {
        log.info("Get all exams by topic");
        return examService.getExamByTopicId(username, topicId);
    }
}
