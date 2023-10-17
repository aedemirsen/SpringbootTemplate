package com.example.domain.mq.model;

import com.example.domain.util.constants.enums.MailSource;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserCreatedTask extends BaseTask {

    private Long userId;
    private MailSource mailSource;
    //If user created mail needs another object
    private Long objectId;

}
