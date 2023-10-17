package com.example.domain.exception;

public class NotFoundException extends BaseException{
    public NotFoundException(String message, String errorCode, Object... args) {
        super(message, errorCode, args);
    }

    public NotFoundException(String errorCode, Object... args) {
        super(errorCode, args);
    }
}
