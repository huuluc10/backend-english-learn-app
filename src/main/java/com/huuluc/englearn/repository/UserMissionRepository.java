package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.UserMission;
import com.huuluc.englearn.mapper.UserMissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserMissionRepository {
    private final UserMissionMapper userMissionMapper;

    public List<UserMission> getByUserId(int userId) {
        return userMissionMapper.findByUserId(userId);
    }

    public int insert(String username, short missionId) {
        return userMissionMapper.insert(username, missionId);
    }

}
