package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.UserLesson;
import com.huuluc.englearn.repository.UserLessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLessonService {
    private final UserLessonRepository userLessonRepository;

    public List<UserLesson> findByUserId(short userId) {
        return userLessonRepository.findByUserId(userId);
    }

    public UserLesson findByLessonId(short lessonId) {
        return userLessonRepository.findByLessonId(lessonId);
    }

    public UserLesson findByUserIdAndLessonId(short userId, short lessonId) {
        return userLessonRepository.findByUserIdAndLessonId(userId, lessonId);
    }
}
