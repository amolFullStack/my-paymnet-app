package com.payment.user_service.controller;

import com.payment.common_model.UserDto;
import com.payment.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
}
