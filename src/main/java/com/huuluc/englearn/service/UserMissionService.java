package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.UserMissionException;
import com.huuluc.englearn.model.UserMission;

import java.util.List;

public interface UserMissionService {
    List<UserMission> findByUserId(String username) throws UserMissionException;

    UserMission findTodayMissionByMissionId(String username, short missionId) throws UserMissionException;

    int checkActiveMissionLastDay(String username) throws UserMissionException;

}
