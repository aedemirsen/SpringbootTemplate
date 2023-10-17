package com.example.domain.mq;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MQConstants {
    public static final String QUEUE_MAIL = "mail_send_queue";
    public static final String QUEUE_USER_CREATED = "user_created_queue";
    public static final String QUEUE_NOTIFICATION = "notification_queue";
    public static final String QUEUE_USER_PASSWORD_CHANGED = "user_password_changed_queue";
}
