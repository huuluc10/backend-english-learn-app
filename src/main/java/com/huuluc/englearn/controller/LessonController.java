package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
@Tag(name = "Lesson", description = "Lesson API")
@Slf4j
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/topic")
    @Operation(summary = "Get list lesson by topic")
    public ResponseEntity<ResponseModel> findByTopicIdAndUsername(GetHistoryLearnRequest request) throws LessonException, MediaException, LevelException {
        log.info("Get list lesson by topic by username: {}", request.getUsername());
        return lessonService.findByTopicIdAndUsername(request);
    }
}
