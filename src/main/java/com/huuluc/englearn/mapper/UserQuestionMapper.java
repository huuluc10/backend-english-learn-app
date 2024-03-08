package com.huuluc.englearn.mapper;


import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.exception.UserQuestionException;
import com.huuluc.englearn.model.UserQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserQuestionMapper {
    @Select("SELECT * FROM user_question WHERE user_id = #{userId}")
    List<UserQuestion> findByUserId(short userId) throws UserQuestionException;

    @Select("SELECT * FROM user_question WHERE question_id = #{questionId}")
    List<UserQuestion> findByQuestionId(short questionId) throws UserQuestionException;

    @Select("SELECT * FROM user_question WHERE user_id = #{userId} AND question_id = #{questionId}")
    List<UserQuestion> findByUserIdAndQuestionId(short userId, short questionId) throws UserQuestionException;

    @Select("SELECT * FROM user_question WHERE user_id = #{userId} AND question_id = #{questionId} AND is_correct = #{isCorrect}")
    List<UserQuestion> findByUserIdAndQuestionIdAndIsCorrect(short userId, short questionId, boolean isCorrect) throws UserQuestionException;

    @Select("SELECT COUNT(*) FROM user_question WHERE DATE(date_done) = DATE(CURDATE()) AND username = #{username}")
    int countTodayQuestion(String username) throws UserQuestionException;

}
