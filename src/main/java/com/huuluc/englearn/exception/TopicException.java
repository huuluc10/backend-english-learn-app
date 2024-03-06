package com.huuluc.englearn.exception;

public class TopicException extends Exception{
    public TopicException(String message) {
        super(message);
    }

    public TopicException(String message, Throwable cause) {
        super(message, cause);
    }
}
