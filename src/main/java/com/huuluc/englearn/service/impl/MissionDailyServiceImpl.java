package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.MissionDaily;
import com.huuluc.englearn.model.response.MissionResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.MissionDailyRepository;
import com.huuluc.englearn.repository.UserLessonRepository;
import com.huuluc.englearn.repository.UserMissionRepository;
import com.huuluc.englearn.repository.UserQuestionRepository;
import com.huuluc.englearn.service.MissionDailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionDailyServiceImpl implements MissionDailyService {
    private final MissionDailyRepository missionDailyRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserLessonRepository userLessonRepository;
    private final UserQuestionRepository userQuestionRepository;

    @Override
    public ResponseEntity<ResponseModel> getAll() throws MissionDailyException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all mission dailies success", missionDailyRepository.getAll());
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getMissionDailyByUserId(String username) throws UserMissionException,
            UserLessonException, QuestionException, MissionDailyException, UserQuestionException {
        List<MissionDaily> missionDailies = missionDailyRepository.getAll();

        List<MissionResponse> missionResponseList = new ArrayList<>();

        //transform missionDailies to MissionResponse
        for (MissionDaily missionDaily : missionDailies) {
            missionResponseList.add(new MissionResponse(missionDaily));
        }

        //check status lesson mission daily
        if (userMissionRepository.findTodayMissionByUsername(username, (short) 1) == null) {
            if (userLessonRepository.countLessonLearnedToday(username) > 0 &&
                    (userMissionRepository.insert(username, (short) 1) == 1)) {
                    missionResponseList.get(0).setDone(true);

            }
        } else {
            missionResponseList.get(0).setDone(true);
        }

        //check status question mission daily
        if (userMissionRepository.findTodayMissionByUsername(username, (short) 2) == null) {
            if (userQuestionRepository.countTodayQuestion(username) > 4 &&
                    (userMissionRepository.insert(username, (short) 2) == 1)) {
                    missionResponseList.get(1).setDone(true);

            }
        } else {
            missionResponseList.get(1).setDone(true);
        }

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get mission daily success", missionResponseList);
        return ResponseEntity.ok(responseModel);
    }
}
