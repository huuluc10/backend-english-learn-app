package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface ExamService {
   ResponseEntity<ResponseModel> getAll() throws ExamException;

   ResponseEntity<ResponseModel> getById(short examId) throws ExamException;

   ResponseEntity<ResponseModel> getExamByTopicId(short topicId) throws ExamException;
}
