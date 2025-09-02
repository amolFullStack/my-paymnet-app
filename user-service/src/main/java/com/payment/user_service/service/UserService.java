package com.payment.user_service.service;

import com.payment.common_model.UserDto;
import com.payment.user_service.client.AccountClient;
import com.payment.user_service.model.UserEntity;
import com.payment.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private AccountClient accountClient;

    public UserDto registerUser(UserDto userDto){
        UserEntity entity = new UserEntity();
        entity.setUsername(userDto.username());
        entity.setEmail(userDto.email());
        entity.setPassword(userDto.password()); // later: hash password
        UserEntity savedUser = repository.save(entity);
        accountClient.createAccount(savedUser.getId());
        return new UserDto(savedUser.getUsername(), savedUser.getEmail(), savedUser.getPassword());
    }
}
