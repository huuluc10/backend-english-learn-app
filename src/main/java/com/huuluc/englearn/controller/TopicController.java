package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.security.JwtUtils;
import com.huuluc.englearn.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/topic")
@Tag(name = "Topic", description = "Topic API")
@Slf4j
public class TopicController {
    private final TopicService topicService;
    private final JwtUtils jwtUtils;

    @GetMapping("/success-rate")
    @Operation(summary = "Get success rate")
    public ResponseEntity<ResponseModel> getSuccessRate(GetHistoryLearnRequest request) throws TopicException {
        log.info("Get success rate");
        return topicService.getSuccessRate(request);
    }

    @GetMapping("/")
    @Operation(summary = "Get all topics")
    public ResponseEntity<ResponseModel> getAll(@RequestHeader String token) throws TopicException {
        log.info("Get all topics");
        // Get username from token
        String username = jwtUtils.getUserNameFromJwtToken(token);
        return topicService.getAllByUser(username);
    }
}
