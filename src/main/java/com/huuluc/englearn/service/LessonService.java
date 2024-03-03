package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Lesson;
import com.huuluc.englearn.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson findById(short lessonId) {
        return lessonRepository.findById(lessonId);
    }

    public List<Lesson> findByTopicId(short topicId) {
        return lessonRepository.findByTopicId(topicId);
    }

    public List<Lesson> findByLevelId(short levelId) {
        return lessonRepository.findByLevelId(levelId);
    }

}
