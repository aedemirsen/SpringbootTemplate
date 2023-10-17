package com.example.domain.repository.user;

import com.example.domain.entity.user.Role;
import com.example.domain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends BaseRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
