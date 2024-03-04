package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.UserLesson;

import java.util.List;

public interface UserLessonService {
    List<UserLesson> findByUserId(short userId);

    UserLesson findByLessonId(short lessonId);

    UserLesson findByUserIdAndLessonId(short userId, short lessonId);
}
