package com.example.restapi.controller;

import com.example.domain.service.interfaces.user.IUserService;
import com.example.restapi.dto.user.UserDto;
import com.example.restapi.mapper.user.IUserMapper;
import com.example.restapi.util.constants.Apis;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(Apis.User.BASE_URL)
public class UserController {

    private final IUserService userService;
    private final IUserMapper userMapper;

    @GetMapping("/")
    public List<UserDto> findAll(@ParameterObject Pageable pageable){
        return userService.findAll(pageable).stream().map(userMapper::fromUser).collect(Collectors.toList());
    }
}
