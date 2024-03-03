package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.UserQuestion;
import com.huuluc.englearn.repository.UserQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQuestionService {
    private final UserQuestionRepository userQuestionRepository;

    public List<UserQuestion> findByUserId(short userId) {
        return userQuestionRepository.findByUserId(userId);
    }

    public List<UserQuestion> findByQuestionId(short questionId) {
        return userQuestionRepository.findByQuestionId(questionId);
    }

    public List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId) {
        return userQuestionRepository.findByUserIdAndQuestionId(userId, questionId);
    }

    public List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect) {
        return userQuestionRepository.findByUserIdAndQuestionIdAndIsCorrect(userId, questionId, isCorrect);
    }
}
