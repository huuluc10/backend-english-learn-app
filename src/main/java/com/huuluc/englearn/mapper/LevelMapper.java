package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.model.Level;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LevelMapper {
    @Select("SELECT * FROM level")
    List<Level> findAll() throws LevelException;

    @Select("SELECT * FROM level WHERE level_id = #{levelId}")
    Level findById(short levelId) throws LevelException;

    @Select("SELECT * FROM level WHERE experience_threshold <= #{exp} ORDER BY experience_threshold DESC LIMIT 1")
    Level findByExp(int exp) throws LevelException;


}
