package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.ExamException;
import com.huuluc.englearn.exception.UserQuestionException;
import com.huuluc.englearn.model.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface ExamMapper {
    @Select("SELECT * FROM exam")
    List<Exam> findAll() throws ExamException;

    @Select("SELECT * FROM exam WHERE exam_id = #{examId}")
    Exam findById(short examId) throws ExamException;

    @Select("SELECT * FROM exam WHERE topic_id = #{topicId}")
    List<Exam> findByTopicId(short topicId) throws ExamException;


    @Select(value= "{ CALL getExamResult(#{username}, #{examId}) }")
    @Options(statementType = StatementType.CALLABLE)
    @ResultType(Integer.class)
    int getExamResult(String username, short examId) throws ExamException;
}
