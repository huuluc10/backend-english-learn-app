package com.huuluc.englearn.exception;


public class UserLessonException extends Exception{
    public UserLessonException(String message) {
        super(message);
    }

    public UserLessonException(String message, Throwable cause) {
        super(message, cause);
    }
}
