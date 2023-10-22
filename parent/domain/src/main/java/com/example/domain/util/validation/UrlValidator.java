package com.example.domain.util.validation;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlValidator {

    public static void isUrlValid(String url) throws MalformedURLException {
        new URL(url);
    }
}
