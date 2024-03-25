package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface LessonService {
    ResponseEntity<ResponseModel> findAll() throws LessonException;

    ResponseEntity<ResponseModel> findById(short lessonId) throws LessonException;

    ResponseEntity<ResponseModel> getSummaryOfTopic(GetHistoryLearnRequest request) throws LessonException;

    ResponseEntity<ResponseModel> findByLevelId(short levelId) throws LessonException;

    ResponseEntity<ResponseModel> findByTopicIdAndUsername(GetHistoryLearnRequest request) throws LessonException, MediaException, LevelException;
}
