package com.example.domain.exception;

public class AlreadyExistsException extends BaseException{

    public AlreadyExistsException(String message, String errorCode){
        super(message, errorCode);
    }

    public AlreadyExistsException(String errorCode, Object... args) {
        super(errorCode, args);
    }
}
