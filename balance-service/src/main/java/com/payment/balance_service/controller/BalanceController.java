package com.payment.balance_service.controller;

import com.payment.balance_service.model.Balance;
import com.payment.balance_service.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/{accountId}")
    public Balance getBalance(@PathVariable("accountId") Long accountId) {
        return balanceService.getBalance(accountId);
    }

    @PostMapping("/{accountId}/update")
    public Balance updateBalance(@PathVariable("accountId") Long accountId,
                                 @RequestParam("amount") BigDecimal amount) {
        return balanceService.updateBalance(accountId, amount);
    }
}
