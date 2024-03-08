package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.QuestionException;
import com.huuluc.englearn.exception.UserLessonException;
import com.huuluc.englearn.exception.UserMissionException;
import com.huuluc.englearn.model.MissionDaily;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MissionDailyService {
    List<MissionDaily> getAll();

    ResponseEntity<ResponseModel> getMissionDailyByUserId(String username) throws UserMissionException, UserLessonException, QuestionException;
}
