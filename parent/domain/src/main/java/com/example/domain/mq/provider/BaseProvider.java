package com.example.domain.mq.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RequiredArgsConstructor
public abstract class BaseProvider {
    protected final RabbitTemplate rabbitTemplate;
}
