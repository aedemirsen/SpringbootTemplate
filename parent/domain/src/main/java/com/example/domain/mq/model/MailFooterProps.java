package com.example.domain.mq.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail.footer")
@Data
public class MailFooterProps {

    private String cookiePolicy;
    private String privacyPolicy;
    private String termsOfUse;
    private String clarificationText;
    private String linkedin;
    private String x;
}
