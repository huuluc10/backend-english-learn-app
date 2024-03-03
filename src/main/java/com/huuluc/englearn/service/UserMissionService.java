package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.UserMission;
import com.huuluc.englearn.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionService {
    private final UserMissionRepository userMissionRepository;

    public List<UserMission> getByUserId(int userId) {
        return userMissionRepository.getByUserId(userId);
    }

    public int add(String username, short missionId) {
        return userMissionRepository.insert(username, missionId);
    }
}
