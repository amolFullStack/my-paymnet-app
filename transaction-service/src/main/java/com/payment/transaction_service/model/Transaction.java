package com.payment.transaction_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;

    private String type;   // CREDIT / DEBIT / TRANSFER
    private String status; // SUCCESS / FAILED

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}



