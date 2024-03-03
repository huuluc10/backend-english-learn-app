package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Exam;
import com.huuluc.englearn.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    public Exam getById(short examId) {
        return examRepository.findById(examId);
    }
}
