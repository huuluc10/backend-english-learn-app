package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.UserLessonException;
import com.huuluc.englearn.model.UserLesson;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.UserLessonRepository;
import com.huuluc.englearn.service.UserLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLessonServiceImpl implements UserLessonService {
    private final UserLessonRepository userLessonRepository;

    @Override
    public ResponseEntity<ResponseModel> insert(UserLesson userLesson) throws UserLessonException {
        ResponseModel responseModel;
        int result = userLessonRepository.insert(userLesson);
        if (result == 0) {
            responseModel = new ResponseModel(MessageStringResponse.ERROR, "Insert user lesson failed", null);
            return ResponseEntity.badRequest().body(responseModel);
        }

       responseModel = new ResponseModel(MessageStringResponse.SUCCESS, "Insert user lesson successfully", null);
        return ResponseEntity.ok(responseModel);
    }
}
