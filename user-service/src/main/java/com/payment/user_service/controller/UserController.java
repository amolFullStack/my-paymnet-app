package com.payment.user_service.controller;

import com.payment.common_model.UserDto;
import com.payment.user_service.client.AccountClient;
import com.payment.user_service.model.UserEntity;
import com.payment.user_service.repository.UserRepository;
import com.payment.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    @PreAuthorize("hasRole('USER')")
    public UserDto register(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
}
