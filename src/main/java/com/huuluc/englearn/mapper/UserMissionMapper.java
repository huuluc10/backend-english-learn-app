package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.UserMissionException;
import com.huuluc.englearn.model.UserMission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMissionMapper {
    @Select("SELECT * FROM user_mission WHERE username = #{username}")
    List<UserMission> findByUsername(String username) throws UserMissionException;

    @Insert("INSERT INTO user_mission (username, mission_id) VALUES (#{userId}, #{missionId}")
    int insert(String username, short missionId) throws UserMissionException;

    @Select("SELECT * FROM user_mission WHERE username = #{username} AND mission_id = #{missionId} AND DATE(date_done) = DATE(CURDATE())")
    UserMission findTodayMissionByUsername(String username, short missionId) throws UserMissionException;
}
