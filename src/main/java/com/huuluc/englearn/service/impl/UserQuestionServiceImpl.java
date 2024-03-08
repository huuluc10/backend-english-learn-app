package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.exception.UserQuestionException;
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
    public List<UserQuestion> findByUserId(short userId) throws UserQuestionException {
        return userQuestionRepository.findByUserId(userId);
    }

    @Override
    public List<UserQuestion> findByQuestionId(short questionId) throws UserQuestionException {
        return userQuestionRepository.findByQuestionId(questionId);
    }

    @Override
    public List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId) throws UserQuestionException {
        return userQuestionRepository.findByUserIdAndQuestionId(userId, questionId);
    }

    @Override
    public List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect) throws UserQuestionException {
        return userQuestionRepository.findByUserIdAndQuestionIdAndIsCorrect(userId, questionId, isCorrect);
    }

    @Override
    public int countTodayQuestion(String username) throws QuestionException, UserQuestionException {
        return userQuestionRepository.countTodayQuestion(username);
    }
}
