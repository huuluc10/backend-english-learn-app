package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.Lesson;
import com.huuluc.englearn.mapper.LessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonRepository {
    private final LessonMapper lessonMapper;

    public List<Lesson> findAll() {
        return lessonMapper.findAll();
    }

    public Lesson findById(short lessonId) {
        return lessonMapper.findById(lessonId);
    }

    public List<Lesson> findByTopicId(short topicId) {
        return lessonMapper.findByTopicId(topicId);
    }

    public List<Lesson> findByLevelId(short levelId) {
        return lessonMapper.findByLevelId(levelId);
    }
}
