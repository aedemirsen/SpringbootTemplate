package com.example.domain.service.interfaces.user;

import com.example.domain.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {

    User findByUsername(String username);

    Optional<User> findById(Long id);

    Page<User> findAll(Pageable pageable);

    User save(User user);

    boolean existsByUsername(String username);
}
