package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.QuestionType;
import com.huuluc.englearn.repository.QuestionTypeRepository;
import com.huuluc.englearn.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionTypeServiceImpl implements QuestionTypeService {
    private final QuestionTypeRepository questionTypeRepository;

    @Override
    public QuestionType findById(short questionTypeId) {
        return questionTypeRepository.findById(questionTypeId);
    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
