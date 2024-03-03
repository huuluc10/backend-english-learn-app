package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Topic;
import com.huuluc.englearn.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public List<Topic> getAll() {
        return topicRepository.getAll();
    }
}
