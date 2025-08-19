package com.payment.user_service.controller;

import com.payment.common_model.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto user) {
        return user; // stub until DB
    }
}
