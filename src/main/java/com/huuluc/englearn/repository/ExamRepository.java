package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.model.Exam;
import com.huuluc.englearn.mapper.ExamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExamRepository {
    private final ExamMapper examMapper;

    public List<Exam> findAll() throws ExamException {
        return examMapper.findAll();
    }


    public Exam findById(short examId) throws ExamException {
        return examMapper.findById(examId);
    }

    public List<Exam> findByTopicId(short topicId) throws ExamException {
        return examMapper.findByTopicId(topicId);
    }

    public int getExamResult(String username, short examId) throws ExamException {
        return examMapper.getExamResult(username, examId);
    }
}
