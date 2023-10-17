package com.example.domain.mq.model;

import com.example.domain.mail.model.EmailData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailSendTask {
    private EmailData emailData;
}
