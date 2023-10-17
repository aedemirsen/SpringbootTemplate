package com.example.restapi.mapper.user;

import com.example.domain.entity.user.User;
import com.example.restapi.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(uses = {IRoleMapper.class} , componentModel = "spring")
public interface IUserMapper {
    UserDto fromUser(User user);

    User toUser(UserDto userDto);
}
