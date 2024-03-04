package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.Topic;
import com.huuluc.englearn.repository.TopicRepository;
import com.huuluc.englearn.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public List<Topic> getAll() {
        return topicRepository.getAll();
    }
}
