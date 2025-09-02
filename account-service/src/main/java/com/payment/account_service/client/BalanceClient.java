package com.payment.account_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "balance-service", url = "http://localhost:8083")
public interface BalanceClient {
    @PostMapping("/balances/init")
    void initializeBalance(@RequestParam("accountId") Long accountId);
}
