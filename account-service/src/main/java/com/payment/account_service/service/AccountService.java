package com.payment.account_service.service;

import com.payment.account_service.client.BalanceClient;
import com.payment.account_service.model.Account;
import com.payment.account_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final BalanceClient balanceClient;

    public Account createAccount(Long userId) {
        Account account = new Account();
        account.setUserId(userId);
        account.setAccountNumber(UUID.randomUUID().toString()); // simple account number
        account.setCreatedAt(LocalDateTime.now());
        account.setStatus("ACTIVE");
        Account savedAccount = accountRepository.save(account);
        // 🚀 Call Balance Service to init balance
        balanceClient.initializeBalance(savedAccount.getId());
        return savedAccount;
    }

    public Account getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId).orElseThrow();
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
