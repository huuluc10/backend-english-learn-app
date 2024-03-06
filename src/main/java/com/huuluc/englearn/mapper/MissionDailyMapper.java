package com.huuluc.englearn.mapper;

import com.huuluc.englearn.model.MissionDaily;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MissionDailyMapper {
    @Select("SELECT * FROM mission_daily")
    List<MissionDaily> findAll();
}
