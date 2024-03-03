package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.QuestionType;
import com.huuluc.englearn.repository.QuestionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionTypeService {
    private final QuestionTypeRepository questionTypeRepository;

    public QuestionType findById(short questionTypeId) {
        return questionTypeRepository.findById(questionTypeId);
    }

    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
