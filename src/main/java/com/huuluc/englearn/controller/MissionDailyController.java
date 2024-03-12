package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MissionDailyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mission-daily")
@Tag(name = "Mission Daily", description = "Mission Daily API")
@Slf4j
public class MissionDailyController {
    private final MissionDailyService missionDailyService;

    @GetMapping("/")
    @Operation(summary = "Get mission daily by user id")
    public ResponseEntity<ResponseModel> getMissionDailyByUserId() throws UserMissionException,
            UserLessonException, QuestionException, MissionDailyException, UserQuestionException, UserException {
        //get username from token and check if it is the same as the username in the request
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        log.info("Get mission daily by {}", username);
        return missionDailyService.getMissionDailyByUserId(username);
    }
}
