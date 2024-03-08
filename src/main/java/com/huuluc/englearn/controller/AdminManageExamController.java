package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.ExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/manage/exam")
@Tag(name = "Admin Manage Exam", description = "Admin API Manage Exam")
public class AdminManageExamController {
    private final ExamService examService;

    @GetMapping("/")
    @Operation(summary = "Get all exams")
    public ResponseEntity<ResponseModel> getAll() throws ExamException {
        return examService.getAll();
    }


    @GetMapping("/id")
    @Operation(summary = "Get exam by id")
    public ResponseEntity<ResponseModel> getById(short examId) throws ExamException {
        return examService.getById(examId);
    }
}
