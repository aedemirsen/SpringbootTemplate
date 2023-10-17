package com.example.restapi.controller;

import com.example.core.payload.GenericResponse;
import com.example.domain.service.interfaces.auth.IAuthenticationService;
import com.example.domain.util.constants.I18nConstants;
import com.example.domain.entity.user.User;
import com.example.domain.model.auth.AuthResponseModel;
import com.example.domain.model.auth.LoginModel;
import com.example.domain.model.auth.RegisterModel;
import com.example.restapi.util.constants.Apis;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(Apis.Auth.BASE_URL)
public class AuthenticationController {

    private final IAuthenticationService authenticationService;

    @PostMapping(Apis.Auth.REGISTER)
    public GenericResponse<User> register(@RequestBody RegisterModel register){
        User savedUser = authenticationService.register(register);
        return GenericResponse.<User>builder()
                .success(true)
                .message(I18nConstants.USER_REGISTRATION_SUCCESS)
                .data(savedUser)
                .build();
    }

    @PostMapping(Apis.Auth.LOGIN)
    public GenericResponse<AuthResponseModel> login(@RequestBody LoginModel login){
        AuthResponseModel authResponseModel = authenticationService.login(login);
        return GenericResponse.<AuthResponseModel>builder()
                .success(true)
                .message(I18nConstants.LOGIN_SUCCESS)
                .data(authResponseModel)
                .build();
    }

}
