package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.utils.MessageStringResponse;
import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.model.Lesson;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.LessonResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.LessonRepository;
import com.huuluc.englearn.repository.LevelRepository;
import com.huuluc.englearn.repository.MediaRepository;
import com.huuluc.englearn.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LevelRepository levelRepository;
    private final MediaRepository mediaRepository;

    @Override
    public ResponseEntity<ResponseModel> findAll() throws LessonException {
        List<Lesson> lessonList = lessonRepository.findAll();

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get all lessons successfully", lessonList);
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> findById(short lessonId) throws LessonException {
        Lesson lesson = lessonRepository.findById(lessonId);

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get lesson by id successfully", lesson);
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getSummaryOfTopic(GetHistoryLearnRequest request) throws LessonException {
        List<Lesson> lessonList = lessonRepository.getSummaryOfTopic(request);

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get summary lesson of topic successfully", lessonList);
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> findByLevelId(short levelId) throws LessonException {
        List<Lesson> lessonList = lessonRepository.findByLevelId(levelId);

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get lessons by level id successfully", lessonList);
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> findByTopicIdAndUsername(GetHistoryLearnRequest request) throws LessonException, MediaException, LevelException {
        String username = request.getUsername();
        short topicId = request.getTopicId();

        List<LessonResponse> lessonResponseList = lessonRepository.findByTopicIdAndUsername(username, topicId);

        //get mediaURL and level nam to lessonResponseList
        for (LessonResponse lessonResponse : lessonResponseList) {
            short levelId = lessonResponse.getLevelId();
            int contentId = lessonResponse.getContent();

            Media media = mediaRepository.findById(contentId);
            Level level = levelRepository.findById(levelId);

            lessonResponse.setContentURL(media.getUrl());
            lessonResponse.setLevelName(level.getLevelName());
        }

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS, "Get lessons by topic id and username successfully", lessonResponseList);
        return ResponseEntity.ok(responseModel);
    }
}
