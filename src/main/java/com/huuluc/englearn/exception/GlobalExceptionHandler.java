package com.huuluc.englearn.exception;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleUserException(UserException e) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with user exception: " + e.getMessage(), null);
        return ResponseEntity.badRequest().body(responseModel);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ResponseModel> handleDuplicateKeyException(DuplicateKeyException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A record with the same key already exists. " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseModel> handleStorageException(StorageException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with storage exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseModel> handleStorageFileNotFoundException(StorageFileNotFoundException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with storage file not found exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FriendRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleFriendRequestException(FriendRequestException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with friend request exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseModel> handleNotFoundException(NotFoundException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with not found exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TopicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleTopicException(TopicException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with topic exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LessonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleLessonException(LessonException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with lesson exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MediaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleMediaException(MediaException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with media exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserLessonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleUserLessonException(UserLessonException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with user lesson exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(QuestionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleQuestionException(QuestionException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with question exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserMissionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleUserMissionException(UserMissionException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with user mission exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> handleExamException(ExamException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with exam exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseModel> handleBadSqlGrammarException(BadSqlGrammarException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with bad sql grammar exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<ResponseModel> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with sql integrity constraint violation exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseModel> handleException(Exception ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
