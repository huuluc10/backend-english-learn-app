package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LessonMapper {
    @Select("SELECT * FROM lesson")
    public List<Lesson> findAll();

    @Select("SELECT * FROM lesson WHERE lesson_id = #{lessonId}")
    public Lesson findById(short lessonId);

    @Select("SELECT * FROM lesson WHERE topic_id = #{topicId}")
    public List<Lesson> findByTopicId(short topicId);

    @Select("SELECT * FROM lesson WHERE level_id = #{levelId}")
    public List<Lesson> findByLevelId(short levelId);

}
