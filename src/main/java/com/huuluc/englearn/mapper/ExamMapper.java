package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamMapper {
    @Select("SELECT * FROM exam")
    public void findAll();

    @Select("SELECT * FROM exam WHERE exam_id = #{examId}")
    List<Exam> findById(short examId);
}
