package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.UserMissionException;
import com.huuluc.englearn.model.UserMission;
import com.huuluc.englearn.mapper.UserMissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserMissionRepository {
    private final UserMissionMapper userMissionMapper;

    public List<UserMission> getByUserId(String username) throws UserMissionException {
        return userMissionMapper.findByUsername(username);
    }

    public int insert(String username, short missionId) throws UserMissionException {
        return userMissionMapper.insert(username, missionId);
    }

    public UserMission findTodayMissionByUsername(String username, short missionId) throws UserMissionException {
        return userMissionMapper.findTodayMissionByUsername(username, missionId);
    }

    public int checkActiveMissionLastDay(String username) throws UserMissionException {
        return userMissionMapper.checkActiveMissionLastDay(username);
    }

    public int checkActiveMissionToday(String username) throws UserMissionException {
        return userMissionMapper.checkActiveMissionToday(username);
    }

}
