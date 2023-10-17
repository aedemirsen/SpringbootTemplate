package com.example.domain.mail.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailData {
    private String to;
    private Locale locale;
    private MailTemplate template;
    private Map<String, Object> model;
}
