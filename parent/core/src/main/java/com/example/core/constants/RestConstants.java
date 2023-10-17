package com.example.core.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestConstants {
    public static final String PUBLIC_API_PREFIX = "/public";

    public static final String[] AUTH_WHITELIST = {
            "/auth/**",
            PUBLIC_API_PREFIX + "/**"
    };
}
