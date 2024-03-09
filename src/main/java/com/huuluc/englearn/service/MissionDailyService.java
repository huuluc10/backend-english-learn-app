package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

public interface MissionDailyService {
    ResponseEntity<ResponseModel> getAll() throws MissionDailyException;

    ResponseEntity<ResponseModel> getMissionDailyByUserId(String username) throws UserMissionException, UserLessonException, QuestionException, MissionDailyException, UserQuestionException;
}
