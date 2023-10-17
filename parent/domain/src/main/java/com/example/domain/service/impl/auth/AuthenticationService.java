package com.example.domain.service.impl.auth;

import com.example.core.constants.SecurityConstants;
import com.example.domain.model.auth.AuthResponseModel;
import com.example.domain.model.auth.LoginModel;
import com.example.domain.model.auth.RegisterModel;
import com.example.domain.entity.user.Role;
import com.example.domain.entity.user.User;
import com.example.domain.exception.user.UsernameAlreadyExistsException;
import com.example.domain.security.JwtProvider;
import com.example.domain.service.interfaces.auth.IAuthenticationService;
import com.example.domain.service.interfaces.user.IRoleService;
import com.example.domain.service.interfaces.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthenticationService implements IAuthenticationService {

    private final IUserService userService;
    private final IRoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public User register(RegisterModel registerModel) {
        var existingUser = userService.findByUsername(registerModel.getUsername());
        if(existingUser != null){
            throw new UsernameAlreadyExistsException();
        }
        //role - first registered user's role is 'USER' by default
        Role role = roleService.findByName(SecurityConstants.USER_ROLE);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        //new user
        User newUser = User.builder()
                .username(registerModel.getUsername())
                .roles(roles)
                .password(passwordEncoder.encode(registerModel.getPassword()))
                .build();

        //save user
        return userService.save(newUser);
    }

    @Override
    public AuthResponseModel login(LoginModel loginModel) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginModel.getUsername(),
                        loginModel.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return AuthResponseModel.builder().accessToken(token).tokenType(SecurityConstants.TOKEN_TYPE).build();
    }
}
