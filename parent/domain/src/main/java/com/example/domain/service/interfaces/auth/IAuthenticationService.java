package com.example.domain.service.interfaces.auth;

import com.example.domain.model.auth.AuthResponseModel;
import com.example.domain.model.auth.LoginModel;
import com.example.domain.model.auth.RegisterModel;
import com.example.domain.entity.user.User;

public interface IAuthenticationService {


    User register(RegisterModel registerModel);

    AuthResponseModel login(LoginModel loginModel);
}
