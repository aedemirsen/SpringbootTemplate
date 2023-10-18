package com.example.restapi.mapper.auth;

import com.example.domain.entity.auth.RegisterModel;
import com.example.restapi.dto.auth.RegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRegisterMapper {
    RegisterDto fromRegisterModel(RegisterModel registerModel);

    RegisterModel toRegisterModel(RegisterDto registerDto);
}
