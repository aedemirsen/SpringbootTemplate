package com.example.restapi.mapper.auth;

import com.example.domain.entity.auth.LoginModel;
import com.example.restapi.dto.auth.LoginDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILoginMapper {
    LoginDto fromLoginModel(LoginModel loginModel);

    LoginModel toLoginModel(LoginDto loginDto);
}
