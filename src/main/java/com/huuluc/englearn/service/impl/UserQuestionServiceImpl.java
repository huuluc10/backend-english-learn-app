package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.UserQuestion;
import com.huuluc.englearn.repository.UserQuestionRepository;
import com.huuluc.englearn.service.UserQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQuestionServiceImpl implements UserQuestionService {
    private final UserQuestionRepository userQuestionRepository;

    @Override
    public List<UserQuestion> findByUserId(short userId) {
        return userQuestionRepository.findByUserId(userId);
    }

    @Override
    public List<UserQuestion> findByQuestionId(short questionId) {
        return userQuestionRepository.findByQuestionId(questionId);
    }

    @Override
    public List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId) {
        return userQuestionRepository.findByUserIdAndQuestionId(userId, questionId);
    }

    @Override
    public List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect) {
        return userQuestionRepository.findByUserIdAndQuestionIdAndIsCorrect(userId, questionId, isCorrect);
    }
}
