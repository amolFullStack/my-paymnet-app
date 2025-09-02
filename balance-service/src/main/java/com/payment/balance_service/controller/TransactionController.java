package com.payment.balance_service.controller;

import com.payment.balance_service.model.Transaction;
import com.payment.balance_service.service.TransactionService;
import com.payment.balance_service.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {


    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepo;

    @PostMapping
    public Transaction create(@RequestBody Transaction tx) {
        return transactionService.saveTransaction(tx);
    }

    @GetMapping("/{accountId}")
    public List<Transaction> getByAccount(@PathVariable("accountId") Long accountId) {
        return transactionRepo.findByAccountId(accountId);
    }
}
