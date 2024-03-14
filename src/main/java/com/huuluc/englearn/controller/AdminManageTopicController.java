package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/v1/manage/topic")
@Tag(name = "Admin Manage Topic", description = "Admin Manage Topic API")
@Slf4j
public class AdminManageTopicController {
    private final TopicService topicService;

    @GetMapping("/")
    @Operation(summary = "Get all topics")
    public ResponseEntity<ResponseModel> getAll() throws TopicException {
        log.info("Admin: Get all topics");
        return topicService.getAll();
    }
}
