package com.huuluc.englearn.exception;

public class LevelException extends Exception{
    public LevelException(String message) {
        super(message);
    }

    public LevelException(String message, Throwable cause) {
        super(message, cause);
    }
}
