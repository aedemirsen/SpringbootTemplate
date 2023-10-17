package com.example.domain.mq.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tr.gov.cbfo.domain.model.notification.NotificationData;
import tr.gov.cbfo.domain.mq.MQConstants;
import tr.gov.cbfo.domain.mq.model.NotificationTask;
import tr.gov.cbfo.domain.service.interfaces.notification.INotificationService;

@Slf4j
@Profile("prod")
@RequiredArgsConstructor
@Component
public class NotificationTaskListener {

    private final INotificationService notificationService;

    @RabbitListener(queues = MQConstants.QUEUE_NOTIFICATION)
    public void listen(NotificationTask notificationTask) {
        NotificationData data = notificationTask.getData();

        log.info("NotificationTask event captured. NotificationType: {}",
            data.getNotificationType().toString());

        try {
            notificationService.saveNotification(data);
        } catch (Exception e) {
            log.error("Exception occurred in NotificationEventListener.", e);
        }
    }
}
