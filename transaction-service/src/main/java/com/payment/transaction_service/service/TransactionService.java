package com.payment.transaction_service.service;

import com.payment.transaction_service.client.BalanceClient;
import com.payment.transaction_service.model.Transaction;
import com.payment.transaction_service.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BalanceClient balanceClient;

    public Transaction transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Transaction tx = new Transaction();
        tx.setFromAccountId(fromAccountId);
        tx.setToAccountId(toAccountId);
        tx.setAmount(amount);
        tx.setType("TRANSFER");

        boolean debited = balanceClient.debit(fromAccountId, amount);
        if (!debited) {
            tx.setStatus("FAILED");
            return transactionRepository.save(tx);
        }

        boolean credited = balanceClient.credit(toAccountId, amount);
        if (!credited) {
            // rollback debit if credit fails (basic Saga-like behavior)
            balanceClient.credit(fromAccountId, amount);
            tx.setStatus("FAILED");
            return transactionRepository.save(tx);
        }

        tx.setStatus("SUCCESS");
        return transactionRepository.save(tx);
    }
}

