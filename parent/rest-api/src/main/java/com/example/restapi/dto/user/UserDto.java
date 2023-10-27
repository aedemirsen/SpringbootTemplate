package com.example.restapi.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class UserDto {

    private String username;
    private String name;
    private String surname;
    private String mailAddress;
    private List<RoleDto> roles;
}
