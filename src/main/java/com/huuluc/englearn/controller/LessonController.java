package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.security.JwtUtils;
import com.huuluc.englearn.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<ResponseModel> findByTopicIdAndUsername(@RequestParam short topicId) throws LessonException,
            MediaException, LevelException {
        //get username from token and check if it is the same as the username in the request
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        log.info("Get list lesson by topic by username: {}", username);
        GetHistoryLearnRequest request = new GetHistoryLearnRequest(username, topicId);
        return lessonService.findByTopicIdAndUsername(request);
    }

    @GetMapping("/topic/{topicId}")
    @Operation(summary = "Get summary lesson by topic")
    public ResponseEntity<ResponseModel> getSummaryOfTopic(@PathVariable short topicId) throws LessonException {
        //get username from token and check if it is the same as the username in the request
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        log.info("Get summary lesson by topic {} and username {}", topicId, username);
        GetHistoryLearnRequest request = new GetHistoryLearnRequest(username, topicId);
        return lessonService.getSummaryOfTopic(request);
    }
}
