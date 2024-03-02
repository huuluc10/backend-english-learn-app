package com.huuluc.englearn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LessonMapper {
    @Select("SELECT * FROM lesson")
    public void findAll();

    @Select("SELECT * FROM lesson WHERE lesson_id = #{lessonId}")
    public void findById(short lessonId);

    @Select("SELECT * FROM lesson WHERE topic_id = #{topicId}")
    public void findByTopicId(short topicId);

    @Select("SELECT * FROM lesson WHERE level_id = #{levelId}")
    public void findByLevelId(short levelId);

}
