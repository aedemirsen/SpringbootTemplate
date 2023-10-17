package com.example.domain.exception.user;

import com.example.domain.exception.NotFoundException;
import com.example.domain.util.constants.I18nConstants;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super(I18nConstants.USER_NOT_FOUND);
    }

}
