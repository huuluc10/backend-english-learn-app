package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.UserMissionException;
import com.huuluc.englearn.model.UserMission;
import com.huuluc.englearn.repository.UserMissionRepository;
import com.huuluc.englearn.service.UserMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionServiceImpl implements UserMissionService {
    private final UserMissionRepository userMissionRepository;

    @Override
    public List<UserMission> findByUserId(String username) {
        return userMissionRepository.getByUserId(username);
    }

    @Override
    public UserMission findTodayMissionByMissionId(String username, short missionId) throws UserMissionException {
        return userMissionRepository.findTodayMissionByUsername(username, missionId);
    }
}
