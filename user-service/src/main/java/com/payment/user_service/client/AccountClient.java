package com.payment.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-service", url = "http://localhost:8084")
public interface AccountClient {

    @PostMapping("/accounts")
    void createAccount(@RequestParam("userId") Long userId);
}
