package com.example.restapi.mapper.auth;

import com.example.domain.entity.auth.AuthResponseModel;
import com.example.restapi.dto.auth.AuthResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthResponseMapper {

    AuthResponseDto fromAuthResponse(AuthResponseModel authResponseModel);

    AuthResponseModel toAuthResponseModel(AuthResponseDto authResponseDto);
}
