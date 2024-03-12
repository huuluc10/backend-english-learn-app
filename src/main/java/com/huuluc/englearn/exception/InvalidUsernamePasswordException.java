package com.huuluc.englearn.exception;

public class InvalidUsernamePasswordException extends Exception {
    public InvalidUsernamePasswordException(String message) {
        super(message);
    }

    public InvalidUsernamePasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
