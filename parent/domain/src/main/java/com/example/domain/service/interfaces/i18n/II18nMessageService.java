package com.example.domain.service.interfaces.i18n;

import java.util.Locale;

public interface II18nMessageService {

    String getMessage(String code, Locale locale, Object... args);

}
