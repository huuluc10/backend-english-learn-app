package com.huuluc.englearn.exception;

public class UserMissionException extends Exception{
    public UserMissionException(String message) {
        super(message);
    }

    public UserMissionException(String message, Throwable cause) {
        super(message, cause);
    }
}
