package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.model.response.ExamResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.ExamRepository;
import com.huuluc.englearn.service.ExamService;
import com.huuluc.englearn.service.LevelService;
import com.huuluc.englearn.service.UserQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;
    private final LevelService levelService;

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
    public int getExamResult(String username, short examId) throws ExamException {
        return examRepository.getExamResult(username, examId);
    }

    @Override
    public ResponseEntity<ResponseModel> getExamByTopicId(String username, short topicId) throws ExamException, LevelException {
        List<Exam> examList = examRepository.findByTopicId(topicId);
        List<ExamResponse> responses = examList.stream().map(ExamResponse::new).toList();

        // Get exam level and result mark by exam level id in examList
        for (int i = 0; i < examList.size(); i++) {
            responses.get(i).setExamLevel(levelService.findById(examList.get(i).getExamLevel()).getLevelName());
            responses.get(i).setExamResult(getExamResult(username, examList.get(i).getExamId()));
        }

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get exam by topic id successfully", responses);
        return ResponseEntity.ok(responseModel);
    }
}
