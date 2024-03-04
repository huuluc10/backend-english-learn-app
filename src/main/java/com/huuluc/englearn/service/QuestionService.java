package com.huuluc.englearn.service;

import com.huuluc.englearn.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findById(short questionId);

    public List<Question> findByLessonId(short lessonId);

    public List<Question> findByExamId(short exam_id);
}
