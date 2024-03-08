package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    List<Question> findById(short questionId);

    public List<Question> findByLessonId(short lessonId);

    public ResponseEntity<ResponseModel> findByExamId(short exam_id) throws QuestionException;
}
