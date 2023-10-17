package com.example.domain.mq.listeners;

import com.example.domain.mail.service.user.interfaces.IUserMailSender;
import com.example.domain.mq.MQConstants;
import com.example.domain.mq.model.UserCreatedTask;
import com.example.domain.service.interfaces.user.IUserService;
import com.example.domain.util.constants.enums.MailSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Profile("prod")
@Component
public class UserCreatedTaskListener {

    private final IUserService userService;
    private final IUserMailSender mailSender;

    @Transactional
    @RabbitListener(queues = MQConstants.QUEUE_USER_CREATED)
    public void listen(UserCreatedTask userCreatedTask) {

        log.info("UserCreatedTask captured. User Id: {}", userCreatedTask.getUserId());

        try {
            sendWelcomeMailByMailSource(userCreatedTask);
        } catch (Exception e) {
            log.error("Exception occurred in UserCreatedTaskListener.", e);
        }
    }

    private void sendWelcomeMailByMailSource(UserCreatedTask userCreatedTask) {
        var userId = userCreatedTask.getUserId();

        var user = userService.findById(userId).orElse(null);
        if (user == null) {
            log.error("User not found for user id: {}", userId);
            return;
        }
        MailSource mailSource = userCreatedTask.getMailSource();
        if (mailSource.equals(MailSource.USER_MANAGEMENT)) {
            mailSender.sendWelcomeMail(user, Boolean.TRUE);
        }
    }
}

