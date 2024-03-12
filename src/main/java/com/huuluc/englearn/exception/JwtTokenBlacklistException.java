package com.huuluc.englearn.exception;


public class JwtTokenBlacklistException extends Exception{
    public JwtTokenBlacklistException(String message) {
        super(message);
    }

    public JwtTokenBlacklistException(String message, Throwable cause) {
        super(message, cause);
    }
}
