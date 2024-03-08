package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findById(short questionId) {
        return questionRepository.findById(questionId);
    }
    @Override

    public List<Question> findByLessonId(short lessonId) {
        return questionRepository.findByLessonId(lessonId);
    }
    @Override

    public ResponseEntity<ResponseModel> findByExamId(short exam_id) throws QuestionException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all questions by exam id", questionRepository.findByExamId(exam_id));
        return ResponseEntity.ok(responseModel);
    }

}
