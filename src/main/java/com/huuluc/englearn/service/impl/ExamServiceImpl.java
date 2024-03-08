package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.ExamRepository;
import com.huuluc.englearn.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;

    @Override
    public ResponseEntity<ResponseModel> getAll() throws ExamException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all exams successfully", examRepository.findAll());
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getById(short examId) throws ExamException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get exam by id successfully", examRepository.findById(examId));
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getExamByTopicId(short topicId) throws ExamException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get exam by topic id successfully", examRepository.findByTopicId(topicId));
        return ResponseEntity.ok(responseModel);
    }
}
