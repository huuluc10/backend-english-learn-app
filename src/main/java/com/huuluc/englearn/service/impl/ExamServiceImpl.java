package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.ExamRepository;
import com.huuluc.englearn.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;

    @Override
    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam getById(short examId) {
        return examRepository.findById(examId);
    }

    @Override
    public ResponseEntity<ResponseModel> getExamByTopicId(short topicId) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get exam by topic id successfully", examRepository.findByTopicId(topicId));
        return ResponseEntity.ok(responseModel);
    }
}
