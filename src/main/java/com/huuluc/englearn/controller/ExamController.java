package com.huuluc.englearn.controller;

import com.huuluc.englearn.entity.Exam;
import com.huuluc.englearn.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exam")
public class ExamController {
    private final ExamService examService;

    @GetMapping("/")
    public List<Exam> getAll() {
        return examService.getAll();
    }

    @GetMapping("/id")
    public Exam getById(short examId) {
        return examService.getById(examId);
    }
}
