package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/v1/manage/topic")
public class AdminManageTopicController {
    private final TopicService topicService;

    @GetMapping("/")
    @Operation(summary = "Get all topics")
    public ResponseEntity<ResponseModel> getAll(GetHistoryLearnRequest request) throws TopicException {
        return topicService.getAll(request);
    }
}
