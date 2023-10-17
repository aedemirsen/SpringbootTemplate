package com.example.domain.mq.listeners;

import com.example.domain.mail.service.user.interfaces.IUserMailSender;
import com.example.domain.mq.MQConstants;
import com.example.domain.mq.model.UserPasswordChangedTask;
import com.example.domain.service.interfaces.user.IUserService;
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
public class UserPasswordChangedTaskListener {

    private final IUserService userService;
    private final IUserMailSender mailSender;

    @Transactional
    @RabbitListener(queues = MQConstants.QUEUE_USER_PASSWORD_CHANGED)
    public void listen(UserPasswordChangedTask userCreatedTask) {
        log.info("UserPasswordChangedTask captured. User Id: {}", userCreatedTask.getId());
        try {
            sendPasswordChangedMailByMailSource(userCreatedTask);
        } catch (Exception e) {
            log.error("Exception occurred in UserPasswordChangedTaskListener.", e);
        }
    }

    private void sendPasswordChangedMailByMailSource(UserPasswordChangedTask userPasswordChangedTask) {
        var userId = userPasswordChangedTask.getId();

        var user = userService.findById(userId).orElse(null);
        if (user == null) {
            log.error("User not found for user Id: {}", userId);
            return;
        }
        mailSender.sendPasswordChangeMail(user);
    }
}

