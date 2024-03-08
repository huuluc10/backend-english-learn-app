package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.QuestionTypeException;
import com.huuluc.englearn.model.QuestionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionTypeMapper {
    @Select("SELECT * FROM question_type")
    List<QuestionType> findAll() throws QuestionTypeException;

    @Select("SELECT * FROM question_type WHERE question_type_id = #{questionTypeId}")
    QuestionType findById(short questionTypeId) throws QuestionTypeException;

}
