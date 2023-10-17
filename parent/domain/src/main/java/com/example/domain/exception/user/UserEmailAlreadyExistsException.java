package com.example.domain.exception.user;

import com.example.domain.exception.AlreadyExistsException;
import com.example.domain.util.constants.I18nConstants;

public class UserEmailAlreadyExistsException extends AlreadyExistsException {
    public UserEmailAlreadyExistsException() {
        super(I18nConstants.USER_EMAIL_ALREADY_EXISTS);
    }
}
