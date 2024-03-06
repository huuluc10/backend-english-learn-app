package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.Topic;
import com.huuluc.englearn.mapper.TopicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TopicRepository {
    private final TopicMapper topicMapper;

    public List<Topic> getAll() throws TopicException {
        return topicMapper.findAll();
    }

    public float getSuccessRate(String username, int topicId) throws TopicException {
        return topicMapper.getSuccessRate(username, topicId);
    }
}
