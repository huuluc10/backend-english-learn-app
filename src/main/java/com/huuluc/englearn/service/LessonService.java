package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();

    Lesson findById(short lessonId);

    List<Lesson> findByTopicId(short topicId);

    List<Lesson> findByLevelId(short levelId);
}
