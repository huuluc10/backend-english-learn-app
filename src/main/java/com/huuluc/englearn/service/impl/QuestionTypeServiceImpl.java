package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.utils.MessageStringResponse;
import com.huuluc.englearn.exception.QuestionTypeException;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.QuestionTypeRepository;
import com.huuluc.englearn.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionTypeServiceImpl implements QuestionTypeService {
    private final QuestionTypeRepository questionTypeRepository;

    @Override
    public ResponseEntity<ResponseModel> findById(short questionTypeId) throws QuestionTypeException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get question type by id successfully", questionTypeRepository.findById(questionTypeId));
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> findAll() throws QuestionTypeException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all question types successfully", questionTypeRepository.findAll());
        return ResponseEntity.ok(responseModel);
    }
}
