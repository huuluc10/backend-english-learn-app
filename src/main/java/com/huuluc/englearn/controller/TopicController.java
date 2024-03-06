package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.Topic;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.TopicService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/topic")
public class TopicController {
    private final TopicService topicService;

    @GetMapping("/")
    public ResponseEntity<ResponseModel> getAll(GetHistoryLearnRequest request) throws TopicException {
        return topicService.getAll(request);
    }

    @GetMapping("/success-rate")
    public ResponseEntity<ResponseModel> getSuccessRate(GetHistoryLearnRequest request) throws TopicException {
        return topicService.getSuccessRate(request);
    }
}
