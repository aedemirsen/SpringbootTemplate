package com.example.domain.util;

import com.example.domain.util.constants.I18nConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class I18nUtils {

    public static Locale getDefaultLocale() {
        return new Locale(I18nConstants.DEFAULT_LANGUAGE, I18nConstants.DEFAULT_COUNTRY);
    }
}
