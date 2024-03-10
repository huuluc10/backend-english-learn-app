package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.exception.UserQuestionException;
import com.huuluc.englearn.model.UserQuestion;
import com.huuluc.englearn.model.request.AnswerQuestionRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserQuestionService {
    List<UserQuestion> findByUserId(short userId) throws UserQuestionException;

    List<UserQuestion> findByQuestionId(short questionId) throws UserQuestionException;

    List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId) throws UserQuestionException;

    List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect) throws UserQuestionException;

    int countTodayQuestion(String username) throws QuestionException, UserQuestionException;

    ResponseEntity<ResponseModel> answerQuestion(AnswerQuestionRequest request) throws UserQuestionException;

    ResponseEntity<ResponseModel> getQuestionByExamId(String username, short examId) throws UserQuestionException;
}
