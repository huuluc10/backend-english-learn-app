package com.huuluc.englearn.service;

import com.huuluc.englearn.model.Exam;

import java.util.List;
public interface ExamService {
   List<Exam> getAll();

   Exam getById(short examId);
}
