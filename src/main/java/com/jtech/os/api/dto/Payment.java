package com.jtech.os.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
