package com.huuluc.englearn.exception;

public class QuestionException extends Exception {
    public QuestionException(String message) {
        super(message);
    }

    public QuestionException(String message, Throwable cause) {
        super(message, cause);
    }
}
