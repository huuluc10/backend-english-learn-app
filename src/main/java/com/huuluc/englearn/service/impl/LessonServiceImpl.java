package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.exception.LessonException;
import com.huuluc.englearn.model.Lesson;
import com.huuluc.englearn.model.request.GetHistoryLearnRequest;
import com.huuluc.englearn.model.response.LessonResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.LessonRepository;
import com.huuluc.englearn.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

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
    public ResponseEntity<ResponseModel> findByTopicId(short topicId) throws LessonException {
        List<Lesson> lessonList = lessonRepository.findByTopicId(topicId);

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                "Get lessons by topic id successfully", lessonList);
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
    public ResponseEntity<ResponseModel> findByTopicIdAndUsername(GetHistoryLearnRequest request) throws LessonException {
        String username = request.getUsername();
        short topicId = request.getTopicId();

        List<LessonResponse> lessonResponseList = lessonRepository.findByTopicIdAndUsername(username, topicId);

        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS, "Get lessons by topic id and username successfully", lessonResponseList);
        return ResponseEntity.ok(responseModel);
    }
}
