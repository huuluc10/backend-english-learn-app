package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/manage/lesson")
@Tag(name = "Admin Manage Lesson", description = "Admin API Manage Lesson")
public class AdminManageLessonController {
    private final LessonService lessonService;

    @GetMapping("/")
    @Operation(summary = "Get list lesson")
    public ResponseEntity<ResponseModel> findAll() throws LessonException {
        return lessonService.findAll();
    }

    @GetMapping("/{lessonId}")
    @Operation(summary = "Get lesson by id")
    public ResponseEntity<ResponseModel> findById(@PathVariable short lessonId) throws LessonException {
        return lessonService.findById(lessonId);
    }
}
