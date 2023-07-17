package com.jtech.os.api.dto;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CloudGatewayFallback implements PaymentClient {

    @Override
    public Payment getPayment(Payment Payment) {
        return new Payment();
    }
}
