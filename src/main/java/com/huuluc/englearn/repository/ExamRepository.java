package com.huuluc.englearn.repository;

import com.huuluc.englearn.mapper.ExamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExamRepository {
    private final ExamMapper examMapper;

    public void findAll() {
        examMapper.findAll();
    }


    public void findById(short examId) {
        examMapper.findById(examId);
    }
}
