package com.example.restapi.mapper.user;

import com.example.domain.entity.user.Role;
import com.example.restapi.dto.user.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRoleMapper {
    RoleDto fromRole(Role role);

    Role toRole(RoleDto roleDto);
}
