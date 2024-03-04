package com.huuluc.englearn.controller;

import com.huuluc.englearn.model.Question;
import com.huuluc.englearn.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
public class QuestionController {
    private final QuestionService questionService;
    @RequestMapping("/findById")
    public List<Question> findById(short questionId) {
        return questionService.findById(questionId);
    }

    @RequestMapping("/findByLessonId")
    public List<Question> findByLessonId(short lessonId) {
        return questionService.findByLessonId(lessonId);
    }

    @RequestMapping("/findByExamId")
    public List<Question> findByExamId(short examId) {
        return questionService.findByExamId(examId);
    }
}
