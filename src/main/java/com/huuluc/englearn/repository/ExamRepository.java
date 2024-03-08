package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.mapper.ExamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExamRepository {
    private final ExamMapper examMapper;

    public List<Exam> findAll() {
        return examMapper.findAll();
    }


    public Exam findById(short examId) {
        return examMapper.findById(examId);
    }

    public List<Exam> findByTopicId(short topicId) {
        return examMapper.findByTopicId(topicId);
    }
}
