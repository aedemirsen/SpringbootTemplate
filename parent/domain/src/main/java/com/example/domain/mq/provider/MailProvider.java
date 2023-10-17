package com.example.domain.mq.provider;

import com.example.domain.mail.model.EmailData;
import com.example.domain.mq.MQConstants;
import com.example.domain.mq.model.MailSendTask;
import com.example.domain.util.I18nUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailProvider {

    private final RabbitTemplate mqTemplate;
    public void sendMail(EmailData emailData) {
        var defaultLocale = I18nUtils.getDefaultLocale();
        emailData.setLocale(defaultLocale);
        var data = MailSendTask.builder().emailData(emailData).build();
        mqTemplate.convertAndSend(MQConstants.QUEUE_MAIL, data);
    }
}
