package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface QuestionService {
    ResponseEntity<ResponseModel> findById(short questionId) throws QuestionException;

    ResponseEntity<ResponseModel> findByLessonId(short lessonId) throws QuestionException;

    ResponseEntity<ResponseModel> findByExamId(short exam_id) throws QuestionException;
}
