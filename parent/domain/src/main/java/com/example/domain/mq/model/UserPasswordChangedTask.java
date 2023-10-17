package com.example.domain.mq.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPasswordChangedTask extends BaseTask {

    private Long id;
}
