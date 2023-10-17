package com.example.domain.mail.service.user.impl;

import com.example.domain.entity.user.User;
import com.example.domain.mail.model.EmailData;
import com.example.domain.mail.model.MailModelKeys;
import com.example.domain.mail.model.MailTemplate;
import com.example.domain.mail.service.user.interfaces.IUserMailSender;
import com.example.domain.mq.provider.MailProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserMailSender implements IUserMailSender {

    private final MailProvider mailProvider;

    @Value("${mail.info}")
    private String infoMailAddress;

    @Override
    public void sendWelcomeMail(User user, boolean sendPasswordMail) {

        MailTemplate template = MailTemplate.WELCOME;

        var email = user.getMailAddress();
        var date = user.getUpdateDate() != null
                ? user.getUpdateDate()
                : (user.getCreateDate() != null ? user.getCreateDate() : LocalDateTime.now());
        var dateStr = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(date);

        var emailData = EmailData.builder()
                .to(email)
                .template(template)
                .model(Map.ofEntries(
                        Map.entry(MailModelKeys.NAME, user.getFullName()),
                        Map.entry(MailModelKeys.USER_NAME, user.getUsername()),
                        Map.entry(MailModelKeys.EMAIL, email),
                        Map.entry(MailModelKeys.CREATE_DATE, dateStr)
                )).build();

        mailProvider.sendMail(emailData);
    }

    @Override
    public void sendPasswordChangeMail(User user) {
        var dateStr = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                .format(LocalDateTime.now());
        var email = EmailData.builder()
                .template(MailTemplate.PASSWORD_CHANGE)
                .to(user.getMailAddress())
                .model(Map.ofEntries(
                        Map.entry(MailModelKeys.FULL_NAME, user.getFullName()),
                        Map.entry(MailModelKeys.CREATE_DATE, dateStr)
                ))
                .build();

        mailProvider.sendMail(email);
    }

}
