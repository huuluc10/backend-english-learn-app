package com.huuluc.englearn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QuestionMapper {
    @Select("SELECT * FROM question WHERE question_id = #{questionId} AND belong_to = 'LESSON'")
    public void findById(short questionId);

    @Select("SELECT * FROM question WHERE lesson_id = #{lessonId}")

    public void findByLessonId(short lessonId);

    @Select("SELECT * FROM question WHERE exam_id = #{exam_id}")
    public void findByExamId(short exam_id);
}
