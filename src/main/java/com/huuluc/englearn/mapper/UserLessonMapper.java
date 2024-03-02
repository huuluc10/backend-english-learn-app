package com.huuluc.englearn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserLessonMapper {
    @Select("SELECT * FROM user_lesson WHERE user_id = #{userId}")
    public void findByUserId(short userId);

    @Select("SELECT * FROM user_lesson WHERE lesson_id = #{lessonId}")
    public void findByLessonId(short lessonId);

    @Select("SELECT * FROM user_lesson WHERE user_id = #{userId} AND lesson_id = #{lessonId}")
    public void findByUserIdAndLessonId(short userId, short lessonId);
}
