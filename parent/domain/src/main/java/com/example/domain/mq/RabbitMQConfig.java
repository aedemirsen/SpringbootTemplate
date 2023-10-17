package com.example.domain.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue mailQueue() {
        return new Queue(MQConstants.QUEUE_MAIL, false);
    }

    @Bean
    public Queue provideUserCreated() {
        return new Queue(MQConstants.QUEUE_USER_CREATED, false);
    }

    @Bean
    public Queue provideUserPasswordCreatedQueue() {
        return new Queue(MQConstants.QUEUE_USER_PASSWORD_CHANGED, false);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        rabbitTemplate.setChannelTransacted(Boolean.TRUE);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
