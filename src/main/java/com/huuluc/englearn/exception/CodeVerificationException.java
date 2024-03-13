package com.huuluc.englearn.exception;

public class CodeVerificationException extends Exception{
    public CodeVerificationException(String message) {
        super(message);
    }

    public CodeVerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
