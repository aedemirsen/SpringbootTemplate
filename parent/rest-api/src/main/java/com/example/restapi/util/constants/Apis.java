package com.example.restapi.util.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Apis {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Auth {
        public static final String BASE_URL = "/auth";
        public static final String REGISTER = "/register";
        public static final String LOGIN = "/login";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class User {
        public static final String BASE_URL = "/api/user";
    }


}
