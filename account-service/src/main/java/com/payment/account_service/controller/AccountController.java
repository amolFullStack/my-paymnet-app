package com.payment.account_service.controller;

import com.payment.account_service.model.Account;
import com.payment.account_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestParam("userId") Long userId) {
        return accountService.createAccount(userId);
    }

    @GetMapping("/{userId}")
    public Account getAccountByUserId(@PathVariable("userId") Long userId) {
        return accountService.getAccountByUserId(userId);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
