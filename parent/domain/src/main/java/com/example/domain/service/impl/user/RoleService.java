package com.example.domain.service.impl.user;

import com.example.domain.entity.user.Role;
import com.example.domain.exception.user.RoleNotFoundException;
import com.example.domain.repository.user.IRoleRepository;
import com.example.domain.service.interfaces.user.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(RoleNotFoundException::new);
    }
}
