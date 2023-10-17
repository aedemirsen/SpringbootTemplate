package com.example.domain.exception.user;

import com.example.domain.exception.NotFoundException;
import com.example.domain.util.constants.I18nConstants;

public class RoleNotFoundException extends NotFoundException {

    public RoleNotFoundException() {
        super(I18nConstants.ROLE_NOT_FOUND);
    }

}
