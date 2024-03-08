package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.model.UserQuestion;

import java.util.List;

public interface UserQuestionService {
    List<UserQuestion> findByUserId(short userId);

    List<UserQuestion> findByQuestionId(short questionId);

    List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId);

    List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect);

    int countTodayQuestion(String username) throws QuestionException;
}
