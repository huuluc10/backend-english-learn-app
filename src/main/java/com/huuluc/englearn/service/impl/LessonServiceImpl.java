package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.Lesson;
import com.huuluc.englearn.repository.LessonRepository;
import com.huuluc.englearn.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(short lessonId) {
        return lessonRepository.findById(lessonId);
    }

    @Override
    public List<Lesson> findByTopicId(short topicId) {
        return lessonRepository.findByTopicId(topicId);
    }

    @Override
    public List<Lesson> findByLevelId(short levelId) {
        return lessonRepository.findByLevelId(levelId);
    }

}
