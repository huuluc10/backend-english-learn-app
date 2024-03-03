package com.huuluc.englearn.repository;

import com.huuluc.englearn.entity.UserLesson;
import com.huuluc.englearn.mapper.UserLessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserLessonRepository {
    private final UserLessonMapper userLessonMapper;

    public List<UserLesson> findByUserId(short userId) {
        return userLessonMapper.findByUserId(userId);
    }

    public UserLesson findByLessonId(short lessonId) {
        return userLessonMapper.findByLessonId(lessonId);
    }

    public UserLesson findByUserIdAndLessonId(short userId, short lessonId) {
        return userLessonMapper.findByUserIdAndLessonId(userId, lessonId);
    }
}
