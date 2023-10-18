package com.example.restapi.controller;

import com.example.core.payload.GenericResponse;
import com.example.domain.service.interfaces.auth.IAuthenticationService;
import com.example.domain.util.constants.I18nConstants;
import com.example.domain.entity.user.User;
import com.example.domain.entity.auth.AuthResponseModel;
import com.example.domain.entity.auth.LoginModel;
import com.example.domain.entity.auth.RegisterModel;
import com.example.restapi.dto.auth.AuthResponseDto;
import com.example.restapi.dto.auth.LoginDto;
import com.example.restapi.dto.auth.RegisterDto;
import com.example.restapi.mapper.auth.IAuthResponseMapper;
import com.example.restapi.mapper.auth.ILoginMapper;
import com.example.restapi.mapper.auth.IRegisterMapper;
import com.example.restapi.util.constants.Apis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Apis.Auth.BASE_URL)
public class AuthenticationController {

    private final IAuthenticationService authenticationService;
    private final IRegisterMapper registerMapper;
    private final ILoginMapper loginMapper;
    private final IAuthResponseMapper authResponseMapper;

    @PostMapping(Apis.Auth.REGISTER)
    public GenericResponse<User> register(@RequestBody RegisterDto registerDto){
        RegisterModel mappedRegisterModel = registerMapper.toRegisterModel(registerDto);
        User savedUser = authenticationService.register(mappedRegisterModel);
        return GenericResponse.<User>builder()
                .success(true)
                .message(I18nConstants.USER_REGISTRATION_SUCCESS)
                .data(savedUser)
                .build();
    }

    @PostMapping(Apis.Auth.LOGIN)
    public GenericResponse<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        LoginModel mappedLoginModel = loginMapper.toLoginModel(loginDto);
        AuthResponseModel authResponseModel = authenticationService.login(mappedLoginModel);
        AuthResponseDto authResponseDto = authResponseMapper.fromAuthResponse(authResponseModel);
        return GenericResponse.<AuthResponseDto>builder()
                .success(true)
                .message(I18nConstants.LOGIN_SUCCESS)
                .data(authResponseDto)
                .build();
    }

}
