package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.MissionDaily;
import com.huuluc.englearn.model.response.MissionResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.*;
import com.huuluc.englearn.service.MissionDailyService;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionDailyServiceImpl implements MissionDailyService {
    private final MissionDailyRepository missionDailyRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserLessonRepository userLessonRepository;
    private final UserQuestionRepository userQuestionRepository;
    private final UserService userService;

    @Override
    public ResponseEntity<ResponseModel> getAll() throws MissionDailyException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all mission dailies success", missionDailyRepository.getAll());
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getMissionDailyByUserId(String username) throws UserMissionException,
            UserLessonException, MissionDailyException, UserQuestionException, UserException {
        List<MissionDaily> missionDailies = missionDailyRepository.getAll();

        //transform missionDailies to MissionResponse by using map function
        List<MissionResponse> missionResponseList = missionDailies.stream().map(MissionResponse::new).toList();

        //check status lesson mission daily
        checkMissionStatus(username, (short) 1, userLessonRepository.countLessonLearnedToday(username) > 0,
                missionResponseList.get(0));

        //check status question mission daily
        checkMissionStatus(username, (short) 2, userQuestionRepository.countTodayQuestion(username) > 4,
                missionResponseList.get(1));

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get mission daily success", missionResponseList);
        return ResponseEntity.ok(responseModel);
    }

    private void checkMissionStatus(String username, short missionType, boolean condition,
                                    MissionResponse missionResponse) throws UserException, UserMissionException {

        // if user complete mission, increase streak and set done to true
        if (userMissionRepository.findTodayMissionByUsername(username, missionType) == null && condition) {
            // if user complete mission, increase streak and set done to true
            if (userService.increaseStreak(username) == 0) {
                throw new UserException("Increase streak failed");
            }

            if (userMissionRepository.insert(username, missionType) == 0) {
                throw new UserMissionException("Insert mission failed");
            }
            missionResponse.setDone(true);
        } else if (userMissionRepository.findTodayMissionByUsername(username, missionType) != null) {
            // if user already complete mission, set done to true
            missionResponse.setDone(true);
        }
    }


}
