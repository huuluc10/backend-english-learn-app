package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final QuestionMapper questionMapper;

    public List<Question> findById(short questionId) throws QuestionException {
        return questionMapper.findById(questionId);
    }

    public List<Question> findByLessonId(short lessonId) throws QuestionException {
        return questionMapper.findByLessonId(lessonId);
    }

    public List<Question> findByExamId(short examId) throws QuestionException {
        return questionMapper.findByExamId(examId);
    }
}
