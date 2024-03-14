package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.utils.MessageStringResponse;
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
    public ResponseEntity<ResponseModel> getAll() throws TopicException {
        List<Topic> topics = topicRepository.getAll();
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_ALL_TOPICS_SUCCESSFULLY, topics);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getAllByUser(GetHistoryLearnRequest request) throws TopicException {
        List<Topic> topics = topicRepository.getAll();
        List<HistoryLearnTopicResponse> historyLearnTopicResponses = new ArrayList<>();
        ResponseModel responseModel;

        // add get success rate for each topic
        for (Topic topic : topics) {
            request.setTopicId(topic.getTopicId());
            responseModel = getSuccessRate(request).getBody();

            if (responseModel == null) {
                responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                        MessageStringResponse.GET_SUCCESS_RATE_SUCCESSFULLY, 0);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            }

            float successRate = (float) responseModel.getData();
            HistoryLearnTopicResponse response = new HistoryLearnTopicResponse(topic, successRate);
            historyLearnTopicResponses.add(response);
        }

       responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_ALL_TOPICS_SUCCESSFULLY, historyLearnTopicResponses);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getSuccessRate(GetHistoryLearnRequest request) throws TopicException {
        String username = request.getUsername();
        short topicId = request.getTopicId();

        float successRate = topicRepository.getSuccessRate(username, topicId);
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_SUCCESS_RATE_SUCCESSFULLY, successRate);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
