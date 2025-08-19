package com.payment.common_model;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record PaymentDto(
        @NotBlank String fromAccount,
        @NotBlank String toAccount,
        BigDecimal amount,
        String reference
) {}