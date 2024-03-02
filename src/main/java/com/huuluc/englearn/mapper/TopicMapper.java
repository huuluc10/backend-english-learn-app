package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TopicMapper {
    @Select("SELECT * FROM topic")
    List<Topic> findAll();
}
