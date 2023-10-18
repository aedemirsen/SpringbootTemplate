package com.example.restapi.unit.controller;

import com.example.domain.entity.user.User;
import com.example.domain.service.impl.user.UserService;
import com.example.restapi.controller.UserController;
import com.example.restapi.mapper.user.IUserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private IUserMapper userMapper;

    @Test
    void shouldFindAllUsers() throws Exception {

        // Create a list of sample users
        List<User> sampleUsers = List.of(User.builder()
                                            .name("Test User ")
                                            .username("Test Username ")
                                            .build());

        // Create a Page object from the sample users
        Page<User> sampleUserPage = new PageImpl<>(sampleUsers);

        Mockito.when(userService.findAll(any(Pageable.class))).thenReturn(sampleUserPage);

        ResultActions resultActions = mockMvc.perform(get("/api/user"));

        // Perform assertions on the response
        resultActions.andExpect(status().isOk())
                     .andExpect(jsonPath("$[0].name").value("Test User 1"))
                     .andExpect(jsonPath("$[0].username").value("Test Username 1"));

        verify(userService, times(1)).findAll(any(Pageable.class));
    }

}
