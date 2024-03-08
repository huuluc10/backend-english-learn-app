package com.huuluc.englearn.exception;

public class QuestionTypeException extends Exception{
    public QuestionTypeException(String message) {
        super(message);
    }

    public QuestionTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
