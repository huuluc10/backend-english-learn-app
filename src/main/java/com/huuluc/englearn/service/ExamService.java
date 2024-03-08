package com.huuluc.englearn.service;

import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface ExamService {
   List<Exam> getAll();

   Exam getById(short examId);

   ResponseEntity<ResponseModel> getExamByTopicId(short topicId);
}
