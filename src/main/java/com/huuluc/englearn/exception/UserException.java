package com.huuluc.englearn.exception;

import org.springframework.http.HttpStatus;

public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

}
