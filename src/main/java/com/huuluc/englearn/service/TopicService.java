package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface TopicService {
    ResponseEntity<ResponseModel> getAll() throws TopicException;
    ResponseEntity<ResponseModel> getAllByUser(GetHistoryLearnRequest request) throws TopicException;

    ResponseEntity<ResponseModel> getSuccessRate(GetHistoryLearnRequest request) throws TopicException;
}
