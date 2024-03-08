package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.QuestionTypeException;
import com.huuluc.englearn.model.QuestionType;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionTypeService {
    ResponseEntity<ResponseModel> findById(short questionTypeId) throws QuestionTypeException;

    ResponseEntity<ResponseModel> findAll() throws QuestionTypeException;
}
