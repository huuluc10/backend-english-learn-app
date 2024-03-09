package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.Topic;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.HistoryLearnTopicResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.TopicRepository;
import com.huuluc.englearn.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public ResponseEntity<ResponseModel> getAll(GetHistoryLearnRequest request) throws TopicException {
        List<Topic> topics = topicRepository.getAll();
        List<HistoryLearnTopicResponse> historyLearnTopicResponses = new ArrayList<>();

        // add get success rate for each topic
        for (Topic topic : topics) {
            request.setTopicId(topic.getTopicId());
            float successRate = (float) getSuccessRate(request).getBody().getData();
            HistoryLearnTopicResponse response = new HistoryLearnTopicResponse(topic, successRate);
            historyLearnTopicResponses.add(response);
        }

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all topics successfully", historyLearnTopicResponses);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getSuccessRate(GetHistoryLearnRequest request) throws TopicException {
        String username = request.getUsername();
        short topicId = request.getTopicId();

        float successRate = topicRepository.getSuccessRate(username, topicId);
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get success rate for topic successfully", successRate);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
