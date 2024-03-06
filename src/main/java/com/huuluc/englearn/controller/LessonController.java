package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/")
    public ResponseEntity<ResponseModel> findAll() throws LessonException {
        return lessonService.findAll();
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<ResponseModel> findById(@PathVariable short lessonId) throws LessonException {
        return lessonService.findById(lessonId);
    }

//    @Operation(summary = "Get list lesson ", description = "Returns lesson and history learn of user")
    @GetMapping("/topic")
    public ResponseEntity<ResponseModel> findByTopicIdAndUsername(GetHistoryLearnRequest request) throws LessonException {
        return lessonService.findByTopicIdAndUsername(request);
    }
}
