package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.model.Lesson;
import com.huuluc.englearn.model.response.LessonResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LessonMapper {
    @Select("SELECT * FROM lesson")
    List<Lesson> findAll() throws LessonException;

    @Select("SELECT * FROM lesson WHERE lesson_id = #{lessonId}")
    Lesson findById(short lessonId) throws LessonException;

    @Select("SELECT * FROM lesson WHERE topic_id = #{topicId}")
    List<Lesson> findByTopicId(short topicId) throws LessonException;

    @Select("SELECT * FROM lesson WHERE level_id = #{levelId}")
    List<Lesson> findByLevelId(short levelId) throws LessonException;

    @Select("SELECT l.*, IF(ul.lesson_id IS NULL, 'No', 'Yes') AS completed\n" +
            "FROM lesson l\n" +
            "LEFT JOIN user_lesson ul ON l.lesson_id = ul.lesson_id AND ul.username = #{username} \n" +
            "WHERE l.topic_id = #{topicId}")
    List<LessonResponse> findByTopicIdAndUsername(String username, short topicId) throws LessonException;

}
