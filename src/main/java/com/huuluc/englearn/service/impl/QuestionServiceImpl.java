package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> findById(short questionId) {
        return questionRepository.findById(questionId);
    }
    @Override

    public List<Question> findByLessonId(short lessonId) {
        return questionRepository.findByLessonId(lessonId);
    }
    @Override

    public List<Question> findByExamId(short exam_id) {
        return questionRepository.findByExamId(exam_id);
    }

}
