package com.huuluc.englearn.exception;

public class MediaException extends Exception{
    public MediaException(String message) {
        super(message);
    }

    public MediaException(String message, Throwable cause) {
        super(message, cause);
    }
}
