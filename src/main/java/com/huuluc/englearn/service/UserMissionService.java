package com.huuluc.englearn.service;

import com.huuluc.englearn.model.UserMission;

import java.util.List;

public interface UserMissionService {
    List<UserMission> findByUserId(short userId);

}
