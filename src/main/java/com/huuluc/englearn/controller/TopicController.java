package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/topic")
@Tag(name = "Topic", description = "Topic API")
public class TopicController {
    private final TopicService topicService;

    @GetMapping("/success-rate")
    @Operation(summary = "Get success rate")
    public ResponseEntity<ResponseModel> getSuccessRate(GetHistoryLearnRequest request) throws TopicException {
        return topicService.getSuccessRate(request);
    }
}
