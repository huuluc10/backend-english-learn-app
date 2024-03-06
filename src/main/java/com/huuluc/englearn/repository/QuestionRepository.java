package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final QuestionMapper questionMapper;

    public List<Question> findById(short questionId) {
        return questionMapper.findById(questionId);
    }

    public List<Question> findByLessonId(short lessonId) {
        return questionMapper.findByLessonId(lessonId);
    }

    public List<Question> findByExamId(short exam_id) {
        return questionMapper.findByExamId(exam_id);
    }
}
