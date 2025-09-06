/*
package com.payment.balance_service.service;

import com.payment.balance_service.model.Balance;
import com.payment.balance_service.model.Transaction;
import com.payment.balance_service.repository.BalanceRepository;
import com.payment.balance_service.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BalanceRepository balanceRepository;

    @Transactional
    public Transaction saveTransaction(Transaction tx) {
        // 1. Save transaction
        Transaction savedTx = transactionRepository.save(tx);

        // 2. Fetch balance (or create new if account doesn't exist)
        Balance balance = balanceRepository.findByAccountId(tx.getAccountId())
                .orElseGet(() -> {
                    Balance b = new Balance();
                    b.setAccountId(tx.getAccountId());
                    b.setBalance(BigDecimal.ZERO);
                    b.setLastUpdated(LocalDateTime.now());
                    return b;
                });

        // 3. Update balance depending on transaction type
        if ("CREDIT".equalsIgnoreCase(tx.getType())) {
            balance.setBalance(balance.getBalance().add(tx.getAmount()));
        } else if ("DEBIT".equalsIgnoreCase(tx.getType())) {
            if (balance.getBalance().compareTo(tx.getAmount()) < 0) {
                throw new RuntimeException("Insufficient balance!");
            }
            balance.setBalance(balance.getBalance().subtract(tx.getAmount()));
        }

        // 4. Update timestamp & save
        balance.setLastUpdated(LocalDateTime.now());
        balanceRepository.save(balance);

        return savedTx;
    }

    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
*/
