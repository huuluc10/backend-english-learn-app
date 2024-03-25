package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.model.Lesson;
import com.huuluc.englearn.mapper.LessonMapper;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonRepository {
    private final LessonMapper lessonMapper;

    public List<Lesson> findAll() throws LessonException {
        return lessonMapper.findAll();
    }

    public Lesson findById(short lessonId) throws LessonException {
        return lessonMapper.findById(lessonId);
    }

    public List<Lesson> getSummaryOfTopic(GetHistoryLearnRequest request) throws LessonException {
        return lessonMapper.getSummaryOfTopic(request);
    }

    public List<Lesson> findByLevelId(short levelId) throws LessonException {
        return lessonMapper.findByLevelId(levelId);
    }

    public List<LessonResponse> findByTopicIdAndUsername(String username, short topicId) throws LessonException {
        return lessonMapper.findByTopicIdAndUsername(username, topicId);
    }
}
