package com.payment.balance_service.repository;

import com.payment.balance_service.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Optional<Balance> findByAccountId(Long accountId);
}


