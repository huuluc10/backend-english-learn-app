package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.UserLessonException;
import com.huuluc.englearn.model.UserLesson;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserLessonService {
    ResponseEntity<ResponseModel> insert(UserLesson userLesson) throws UserLessonException;

    int countLessonLearnedToday(String username) throws UserLessonException;
}
