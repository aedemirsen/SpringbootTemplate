package com.example.domain.exception.user;

import com.example.domain.exception.BaseException;
import com.example.domain.util.constants.I18nConstants;

public class PasswordNotMatchedException extends BaseException {
    public PasswordNotMatchedException() {
        super(I18nConstants.PASSWORD_NOT_MATCHED);
    }
}
