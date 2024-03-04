package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.UserLesson;
import com.huuluc.englearn.repository.UserLessonRepository;
import com.huuluc.englearn.service.UserLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLessonServiceImpl implements UserLessonService {
    private final UserLessonRepository userLessonRepository;

    @Override
    public List<UserLesson> findByUserId(short userId) {
        return userLessonRepository.findByUserId(userId);
    }

    @Override
    public UserLesson findByLessonId(short lessonId) {
        return userLessonRepository.findByLessonId(lessonId);
    }

    @Override
    public UserLesson findByUserIdAndLessonId(short userId, short lessonId) {
        return userLessonRepository.findByUserIdAndLessonId(userId, lessonId);
    }
}
