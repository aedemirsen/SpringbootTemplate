package com.example.domain.exception.user;

import com.example.domain.exception.BaseException;
import com.example.domain.util.constants.I18nConstants;

public class UsernameAlreadyExistsException extends BaseException {

    public UsernameAlreadyExistsException(){
        super(I18nConstants.USERNAME_ALREADY_EXISTS);
    }
}
