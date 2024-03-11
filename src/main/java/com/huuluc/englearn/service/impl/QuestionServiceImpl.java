package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.utils.MessageStringResponse;
import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.huuluc.englearn.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public ResponseEntity<ResponseModel> findById(short questionId) throws QuestionException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all questions by question id", questionRepository.findById(questionId));
        return ResponseEntity.ok(responseModel);
    }
    @Override

    public ResponseEntity<ResponseModel> findByLessonId(short lessonId) throws QuestionException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all questions by lesson id", questionRepository.findByLessonId(lessonId));
        return ResponseEntity.ok(responseModel);
    }
    @Override

    public ResponseEntity<ResponseModel> findByExamId(short examId) throws QuestionException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all questions by exam id", questionRepository.findByExamId(examId));
        return ResponseEntity.ok(responseModel);
    }

}
