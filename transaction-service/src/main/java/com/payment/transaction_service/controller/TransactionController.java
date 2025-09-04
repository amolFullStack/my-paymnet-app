package com.payment.transaction_service.controller;

import com.payment.transaction_service.model.Transaction;
import com.payment.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping("/transfer")
    public Transaction transfer(@RequestParam Long fromAccountId,
                                @RequestParam Long toAccountId,
                                @RequestParam BigDecimal amount) {
        return transactionService.transfer(fromAccountId, toAccountId, amount);
    }
}

