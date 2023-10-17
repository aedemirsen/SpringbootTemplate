package com.example.domain.model.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponseModel {
    private String accessToken;
    private String tokenType;
}
