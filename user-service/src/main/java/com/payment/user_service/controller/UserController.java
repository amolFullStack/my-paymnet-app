package com.payment.user_service.controller;

import com.payment.common_model.UserDto;
import com.payment.user_service.model.UserEntity;
import com.payment.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    @PreAuthorize("hasRole('USER')")
    public UserDto register(@RequestBody UserDto userDto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(userDto.username());
        entity.setEmail(userDto.email());
        entity.setPassword(userDto.password()); // later: hash password
        UserEntity saved = repository.save(entity);
        return new UserDto(saved.getUsername(), saved.getEmail(), saved.getPassword());
    }
}
