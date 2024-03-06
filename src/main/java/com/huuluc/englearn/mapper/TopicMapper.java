package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.TopicException;
import com.huuluc.englearn.model.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TopicMapper {
    @Select("SELECT * FROM topic")
    List<Topic> findAll() throws TopicException;

    @Select("SELECT COUNT(ul.lesson_id) * 100 / (SELECT COUNT(lesson_id) FROM lesson WHERE topic_id = 1) AS percentage \n" +
            "FROM user_lesson ul \n" +
            "JOIN lesson l on ul.lesson_id = l.lesson_id \n" +
            "JOIN topic t on l.topic_id = t.topic_id \n" +
            "WHERE username = #{username} AND l.topic_id = #{topicId}")
    float getSuccessRate(String username, int topicId) throws TopicException;
}
