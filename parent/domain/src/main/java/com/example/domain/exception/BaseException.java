package com.example.domain.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private String errorCode;
    private Object[] args;

    public BaseException(String message, Throwable cause, String errorCode, Object... args) {
        super(message, cause);
        init(errorCode, args);
    }

    public BaseException(String message, String errorCode, Object... args) {
        super(message);
        init(errorCode, args);
    }

    public BaseException(String errorCode, Object... args) {
        init(errorCode, args);
    }

    public BaseException(String message) {
        super(message);
    }

    private void init(String errorCode, Object... args){
        this.errorCode = errorCode;
        this.args = args;
    }
}
