package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.UserQuestion;

import java.util.List;

public interface UserQuestionService {
    List<UserQuestion> findByUserId(short userId);

    public List<UserQuestion> findByQuestionId(short questionId);

    public List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId);

    public List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect);
}
