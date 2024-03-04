package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.UserMission;
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
    public List<UserMission> findByUserId(short userId) {
        return userMissionRepository.getByUserId(userId);
    }
}
