package com.example.domain.service.impl;

import com.example.domain.entity.user.Role;
import com.example.domain.entity.user.User;
import com.example.domain.service.interfaces.user.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userService.findByUsername(username);
        if(user == null){
            log.error(username + ": user not found.");
            throw new UsernameNotFoundException(username + ": user not found.");
        }
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
