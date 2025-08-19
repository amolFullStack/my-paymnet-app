package com.payment.common_model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank String username,
        @Email String email,
        @NotBlank String password
) {}