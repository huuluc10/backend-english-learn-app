package com.huuluc.englearn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionTypeMapper {
    @Select("SELECT * FROM question_type")
    public void findAll();

    @Select("SELECT * FROM question_type WHERE question_type_id = #{questionTypeId}")
    public void findById(short questionTypeId);

}
