package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.UserLessonException;
import com.huuluc.englearn.model.UserLesson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserLessonMapper {
    @Insert("INSERT INTO user_lesson (lesson_id, username) VALUES (#{lessonId}, #{username})")
    int insert(UserLesson userLesson) throws UserLessonException;
}
