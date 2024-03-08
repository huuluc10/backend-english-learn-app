package com.huuluc.englearn.exception;

public class MediaTypeException extends Exception{
    public MediaTypeException(String message) {
        super(message);
    }

    public MediaTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
