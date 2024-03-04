package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.UserLesson;
import com.huuluc.englearn.entity.UserMission;

import java.util.List;

public interface UserMissionService {
    List<UserMission> findByUserId(short userId);

}
