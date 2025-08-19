package com.payment.common_model;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record AccountDto(
        @NotBlank String userId,
        String accountNumber,
        BigDecimal balance
) {}