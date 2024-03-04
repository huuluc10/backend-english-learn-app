package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.QuestionType;

import java.util.List;

public interface QuestionTypeService {
    QuestionType findById(short questionTypeId);

    public List<QuestionType> findAll();
}
