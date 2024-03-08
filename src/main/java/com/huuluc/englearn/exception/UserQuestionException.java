package com.huuluc.englearn.exception;

public class UserQuestionException extends Exception{
    public UserQuestionException(String message) {
        super(message);
    }

    public UserQuestionException(String message, Throwable cause) {
        super(message, cause);
    }
}
