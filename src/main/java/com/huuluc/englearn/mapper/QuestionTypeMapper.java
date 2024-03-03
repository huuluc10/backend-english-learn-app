package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.QuestionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionTypeMapper {
    @Select("SELECT * FROM question_type")
    List<QuestionType> findAll();

    @Select("SELECT * FROM question_type WHERE question_type_id = #{questionTypeId}")
    QuestionType findById(short questionTypeId);

}
