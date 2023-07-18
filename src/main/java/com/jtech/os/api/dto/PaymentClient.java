package com.jtech.os.api.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "PAYMENT-SERVICE", url = "http://localhost:9191", fallback = CloudGatewayFallback.class)
public interface PaymentClient {
    @PostMapping(value = "/payment/dopayment")
    Payment getPayment(@RequestBody Payment payment);

}
