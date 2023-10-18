package com.example.domain.service.interfaces.auth;

import com.example.domain.entity.auth.AuthResponseModel;
import com.example.domain.entity.auth.LoginModel;
import com.example.domain.entity.auth.RegisterModel;
import com.example.domain.entity.user.User;

public interface IAuthenticationService {

    User register(RegisterModel registerModel);

    AuthResponseModel login(LoginModel loginModel);
}
