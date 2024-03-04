package com.huuluc.englearn.exception;

public class FriendRequestException extends Exception {
    public FriendRequestException(String message) {
        super(message);
    }

    public FriendRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
