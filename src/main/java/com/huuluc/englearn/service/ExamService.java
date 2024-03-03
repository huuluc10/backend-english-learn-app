package com.huuluc.englearn.service;

import com.huuluc.englearn.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    public void getAll() {
        examRepository.findAll();
    }

    public void getById(short examId) {
        examRepository.findById(examId);
    }
}
