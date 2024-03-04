package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.Exam;
import com.huuluc.englearn.repository.ExamRepository;
import com.huuluc.englearn.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;

    @Override
    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam getById(short examId) {
        return examRepository.findById(examId);
    }
}
