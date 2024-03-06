package com.huuluc.englearn.mapper;

import com.huuluc.englearn.model.UserMission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMissionMapper {
    @Select("SELECT * FROM user_mission WHERE user_id = #{userId}")
    List<UserMission> findByUserId(int userId);

    @Insert("INSERT INTO user_mission (user_id, mission_id) VALUES (#{userId}, #{missionId}")
    int insert(String username, short missionId);
}
