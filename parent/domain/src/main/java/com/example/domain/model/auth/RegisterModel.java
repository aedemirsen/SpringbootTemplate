package com.example.domain.model.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegisterModel {
    private String username;
    private String password;
}
