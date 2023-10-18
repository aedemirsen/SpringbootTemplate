package com.example.restapi.unit.service;


import com.example.domain.entity.user.User;
import com.example.domain.repository.user.IUserRepository;
import com.example.domain.service.impl.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private IUserRepository userRepository;

    private User sampleUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleUser = User.builder()
                .id(1L)
                .name("User")
                .username("Test Username")
                .mailAddress("test@test.com")
                .build();
    }

    @Test
    public void shouldFindUserByUsernameTest() {
        String username = "Test Username";

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(sampleUser));

        User result = userService.findByUsername(username);

        assertEquals(sampleUser, result);
    }

    @Test
    public void shouldFindUserByIdTest() {
        Long id = 1L;

        when(userRepository.findById(id)).thenReturn(Optional.of(sampleUser));

        Optional<User> result = userService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(sampleUser, result.get());
    }

    @Test
    public void shouldFindAllUsersTest() {
        // Create a list of sample users
        List<User> sampleUsers = IntStream.range(1, 6)
                .mapToObj(i -> User.builder()
                        .name("Test User " + i)
                        .username("Test Username " + i)
                        .build())
                .collect(Collectors.toList());

        // Create a Page object from the sample users
        Page<User> sampleUserPage = new PageImpl<>(sampleUsers);

        when(userRepository.findAll(any(Pageable.class))).thenReturn(sampleUserPage);

        Page<User> result = userService.findAll(mock(Pageable.class));

        assertEquals(sampleUserPage, result);

        verify(userRepository).findAll(any(Pageable.class));
    }

    @Test
    void shouldSaveUserTest() {

        when(userRepository.save(sampleUser)).thenReturn(sampleUser);

        var q = userService.save(sampleUser);

        ArgumentCaptor<User> questionArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(questionArgumentCaptor.capture());

        assertThat(q).isNotNull();
        assertThat(questionArgumentCaptor.getValue()).isEqualTo(q);
    }

    @Test
    public void shouldReturnTrueIfUserExistsByUsernameTest() {
        String username = "Test Username";

        when(userRepository.existsByUsername(username)).thenReturn(Boolean.TRUE);

        boolean result = userService.existsByUsername(username);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfUserNotExistsByUsernameTest() {
        String username = "Wrong Username";

        when(userRepository.existsByUsername(username)).thenReturn(Boolean.FALSE);

        boolean result = userService.existsByUsername(username);

        assertFalse(result);
    }

}
