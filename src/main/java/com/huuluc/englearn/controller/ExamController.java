package com.huuluc.englearn.controller;

import com.huuluc.englearn.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exam")
public class ExamController {
    private final ExamService examService;

    @RequestMapping("/")
    public void getAll() {
        examService.getAll();
    }

    @RequestMapping("/id")
    public void getById(short examId) {
        examService.getById(examId);
    }
}
