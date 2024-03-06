package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.UserLessonException;
import com.huuluc.englearn.model.UserLesson;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.UserLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-lesson")
public class UserLessonController {
    private final UserLessonService userLessonService;
    @PostMapping("/")
    public ResponseEntity<ResponseModel> insert(@RequestBody UserLesson userLesson) throws UserLessonException {
        return userLessonService.insert(userLesson);
    }
}
