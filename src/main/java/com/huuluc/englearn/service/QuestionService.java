package com.huuluc.englearn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.huuluc.englearn.entity.Question;
import com.huuluc.englearn.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findById(short questionId) {
        return questionRepository.findById(questionId);
    }

    public List<Question> findByLessonId(short lessonId) {
        return questionRepository.findByLessonId(lessonId);
    }

    public List<Question> findByExamId(short exam_id) {
        return questionRepository.findByExamId(exam_id);
    }

}
