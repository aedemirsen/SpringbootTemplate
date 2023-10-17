package com.example.domain.mq.provider;

import com.example.domain.mq.MQConstants;
import com.example.domain.mq.model.UserCreatedTask;
import com.example.domain.util.constants.enums.MailSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreatedTaskProvider extends BaseProvider {

    public UserCreatedTaskProvider(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

    public void send(Long userId, MailSource mailSource, Long objectId) {

        log.info("UserCreatedTask fired. User Id: {}", userId);

        var event = new UserCreatedTask(userId, mailSource, objectId);
        rabbitTemplate.convertAndSend(MQConstants.QUEUE_USER_CREATED, event);
    }
}
