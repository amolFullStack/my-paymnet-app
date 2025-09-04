package com.payment.transaction_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "balance-service", url = "http://localhost:8083")
public interface BalanceClient {
    @PostMapping("/balances/debit")
    boolean debit(@RequestParam("accountId") Long accountId,
                  @RequestParam("amount") BigDecimal amount);

    @PostMapping("/balances/credit")
    boolean credit(@RequestParam("accountId") Long accountId,
                   @RequestParam("amount") BigDecimal amount);
}
