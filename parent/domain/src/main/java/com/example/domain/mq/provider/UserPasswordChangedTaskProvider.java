package com.example.domain.mq.provider;

import com.example.domain.mq.MQConstants;
import com.example.domain.mq.model.UserPasswordChangedTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserPasswordChangedTaskProvider extends BaseProvider {
    public UserPasswordChangedTaskProvider(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }
    public void send(Long id) {
        log.info("UserPasswordChangedTask fired. User id: {}", id);

        var event = new UserPasswordChangedTask(id);
        rabbitTemplate.convertAndSend(MQConstants.QUEUE_USER_PASSWORD_CHANGED, event);
    }

}
