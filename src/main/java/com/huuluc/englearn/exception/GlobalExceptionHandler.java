package com.huuluc.englearn.exception;

import com.huuluc.englearn.constants.MessageStringResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseModel> handleUserException(UserException e) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with user exception: " + e.getMessage(), null);
        return ResponseEntity.badRequest().body(responseModel);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ResponseModel> handleDuplicateKeyException(DuplicateKeyException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A record with the same key already exists. " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ResponseModel> handleStorageException(StorageException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with storage exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<ResponseModel> handleStorageFileNotFoundException(StorageFileNotFoundException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with storage file not found exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FriendRequestException.class)
    public ResponseEntity<ResponseModel> handleFriendRequestException(FriendRequestException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with friend request exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseModel> handleNotFoundException(NotFoundException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with not found exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TopicException.class)
    public ResponseEntity<ResponseModel> handleTopicException(TopicException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with topic exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LessonException.class)
    public ResponseEntity<ResponseModel> handleLessonException(LessonException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with lesson exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<ResponseModel> handleBadSqlGrammarException(BadSqlGrammarException ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with bad sql grammar exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> handleException(Exception ex) {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.ERROR,
                "A error occur with exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
