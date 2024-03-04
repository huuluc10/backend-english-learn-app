package com.huuluc.englearn.mapper;

import com.huuluc.englearn.model.UserLesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserLessonMapper {
    @Select("SELECT * FROM user_lesson WHERE user_id = #{userId}")
    List<UserLesson> findByUserId(short userId);

    @Select("SELECT * FROM user_lesson WHERE lesson_id = #{lessonId}")
    UserLesson findByLessonId(short lessonId);

    @Select("SELECT * FROM user_lesson WHERE user_id = #{userId} AND lesson_id = #{lessonId}")
    UserLesson findByUserIdAndLessonId(short userId, short lessonId);
}
