package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.service.ExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/manage/exam")
@Tag(name = "Admin Manage Exam", description = "Admin API Manage Exam")
public class AdminManageExamController {
    private final ExamService examService;

    @GetMapping("/")
    @Operation(summary = "Get all exams")
    public List<Exam> getAll() {
        return examService.getAll();
    }


    @GetMapping("/id")
    @Operation(summary = "Get exam by id")
    public Exam getById(short examId) {
        return examService.getById(examId);
    }
}
