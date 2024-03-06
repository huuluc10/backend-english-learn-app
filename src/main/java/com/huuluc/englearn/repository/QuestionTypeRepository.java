package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.QuestionType;
import com.huuluc.englearn.mapper.QuestionTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionTypeRepository {
    private final QuestionTypeMapper questionTypeMapper;

    public QuestionType findById(short questionTypeId) {
        return questionTypeMapper.findById(questionTypeId);
    }

    public List<QuestionType> findAll() {
        return questionTypeMapper.findAll();
    }

}
