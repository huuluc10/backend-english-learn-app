package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Topic;
import com.huuluc.englearn.service.TopicService;
import lombok.RequiredArgsConstructor;
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
    public List<Topic> getAll() {
        return topicService.getAll();
    }
}
