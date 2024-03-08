package com.huuluc.englearn.exception;

public class ExamException extends Exception{
    public ExamException(String message) {
        super(message);
    }

    public ExamException(String message, Throwable cause) {
        super(message, cause);
    }
}
