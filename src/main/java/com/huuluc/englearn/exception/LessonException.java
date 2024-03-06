package com.huuluc.englearn.exception;

public class LessonException extends Exception {
    public LessonException(String message) {
        super(message);
    }

    public LessonException(String message, Throwable cause) {
        super(message, cause);
    }
}
