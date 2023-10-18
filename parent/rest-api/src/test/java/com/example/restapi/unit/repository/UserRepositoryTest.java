package com.example.restapi.unit.repository;

import com.example.domain.entity.user.User;
import com.example.domain.repository.user.IUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private IUserRepository userRepository;

    private static User sampleUser;

    @BeforeAll
    public static void initSampleUser() {
        sampleUser = User.builder()
                .name("testuser")
                .mailAddress("test@test.com")
                .username("testusername")
                .build();
    }

    @Test
    public void shouldFindUserByUsernameTest(){
        userRepository.save(sampleUser);

        Optional<User> foundUser = userRepository.findByUsername("testusername");

        assertTrue(foundUser.isPresent());
        assertEquals(sampleUser.getUsername(), foundUser.get().getUsername());
    }

    @Test
    public void shouldNotFindUserByWrongUsernameTest(){
        userRepository.save(sampleUser);

        Optional<User> foundUser = userRepository.findByUsername("wrongusername");

        assertTrue(foundUser.isEmpty());
    }

    @Test
    public void shouldReturnTrueIfUserExistsByUsernameTest(){
        userRepository.save(sampleUser);

        boolean exists = userRepository.existsByUsername("testusername");

        assertTrue(exists);
    }

    @Test
    public void shouldReturnFalseIfUserNotExistsByUsernameTest(){
        userRepository.save(sampleUser);

        boolean exists = userRepository.existsByUsername("wrongusername");

        assertFalse(exists);
    }
}
