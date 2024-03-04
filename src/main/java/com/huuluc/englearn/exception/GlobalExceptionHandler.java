package com.huuluc.englearn.exception;

import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseModel> handleUserException(UserException e) {
        ResponseModel responseModel = new ResponseModel("error",
                "A error occur with user exception: " + e.getMessage(), null);
        return ResponseEntity.badRequest().body(responseModel);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex) {
        ResponseModel responseModel = new ResponseModel("error",
                "A record with the same key already exists. " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<Object> handleStorageException(StorageException ex) {
        ResponseModel responseModel = new ResponseModel("error",
                "A error occur with storage exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<Object> handleStorageFileNotFoundException(StorageFileNotFoundException ex) {
        ResponseModel responseModel = new ResponseModel("error",
                "A error occur with storage file not found exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ResponseModel responseModel = new ResponseModel("error",
                "A error occur with exception: " + ex.getMessage(), null);
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
