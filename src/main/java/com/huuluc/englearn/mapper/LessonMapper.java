package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LessonMapper {
    @Select("SELECT * FROM lesson")
    List<Lesson> findAll();

    @Select("SELECT * FROM lesson WHERE lesson_id = #{lessonId}")
    Lesson findById(short lessonId);

    @Select("SELECT * FROM lesson WHERE topic_id = #{topicId}")
    List<Lesson> findByTopicId(short topicId);

    @Select("SELECT * FROM lesson WHERE level_id = #{levelId}")
    List<Lesson> findByLevelId(short levelId);

}
