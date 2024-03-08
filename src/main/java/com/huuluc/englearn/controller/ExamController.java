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
@RequestMapping("/api/v1/exam")
@Tag(name = "Exam", description = "Exam API")
public class ExamController {
    private final ExamService examService;

}
