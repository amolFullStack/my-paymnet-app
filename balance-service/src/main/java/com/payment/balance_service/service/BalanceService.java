package com.payment.balance_service.service;

import com.payment.balance_service.model.Balance;
import com.payment.balance_service.repository.BalanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    public Balance getBalance(Long accountId) {
        return balanceRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Balance not found"));
    }

    public Balance updateBalance(Long accountId, BigDecimal amount) {
        Balance balance = balanceRepository.findByAccountId(accountId)
                .orElse(new Balance());
        balance.setAccountId(accountId);
        balance.setBalance(balance.getBalance() == null ? amount :
                balance.getBalance().add(amount));
        balance.setLastUpdated(LocalDateTime.now());
        return balanceRepository.save(balance);
    }

    public Balance initiateBalance(Long accountId){
        Balance balance = new Balance();
        balance.setAccountId(accountId);
        balance.setBalance(BigDecimal.ZERO);
        balance.setLastUpdated(LocalDateTime.now());
        return balanceRepository.save(balance);
    }

    @Transactional
    public void debit(Long accountId, BigDecimal amount) {
        Balance balance = balanceRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (balance.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        balance.setBalance(balance.getBalance().subtract(amount));
        balanceRepository.save(balance);
    }

    @Transactional
    public void credit(Long accountId, BigDecimal amount) {
        Balance balance = balanceRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        balance.setBalance(balance.getBalance().add(amount));
        balanceRepository.save(balance);
    }
}

