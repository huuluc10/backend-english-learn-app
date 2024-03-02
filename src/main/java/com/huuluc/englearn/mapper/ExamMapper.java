package com.huuluc.englearn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ExamMapper {
    @Select("SELECT * FROM exam")
    public void findAll();

    @Select("SELECT * FROM exam WHERE exam_id = #{examId}")
    public void findById(short examId);
}
