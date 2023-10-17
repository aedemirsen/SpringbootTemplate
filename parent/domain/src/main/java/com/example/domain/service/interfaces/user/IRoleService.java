package com.example.domain.service.interfaces.user;


import com.example.domain.entity.user.Role;

public interface IRoleService {

    Role findByName(String name);

}
