package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.exception.UserQuestionException;
import com.huuluc.englearn.model.UserQuestion;
import com.huuluc.englearn.mapper.UserQuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserQuestionRepository {
    private final UserQuestionMapper userQuestionMapper;

    public List<UserQuestion> findByUserId(short userId) throws UserQuestionException {
        return userQuestionMapper.findByUserId(userId);
    }

    public List<UserQuestion> findByQuestionId(short questionId) throws UserQuestionException {
        return userQuestionMapper.findByQuestionId(questionId);
    }

    public List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId) throws UserQuestionException {
        return userQuestionMapper.findByUserIdAndQuestionId(userId, questionId);
    }

    public List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect) throws UserQuestionException {
        return userQuestionMapper.findByUserIdAndQuestionIdAndIsCorrect(userId, questionId, isCorrect);
    }

    public int countTodayQuestion(String username) throws UserQuestionException {
        return userQuestionMapper.countTodayQuestion(username);
    }
}
