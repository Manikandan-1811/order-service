package com.jtech.os.api.service;

import com.jtech.os.api.dto.Payment;
import com.jtech.os.api.dto.PaymentClient;
import com.jtech.os.api.dto.TransactionRequest;
import com.jtech.os.api.dto.TransactionResponse;
import com.jtech.os.api.entity.Order;
import com.jtech.os.api.exception.EmptyInputException;
import com.jtech.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    @Lazy
    RestTemplate restTemplate;
    @Autowired
    private PaymentClient paymentClient;
@Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPONT_URL;
    public TransactionResponse saveOrder(TransactionRequest request) {
       String response = "";
        Order order = request.getOrder();
        if(order.getName().isEmpty() || order.getName().length() ==0 ){
            throw new EmptyInputException("1000","Order name should not be Empty");
        }
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymetResponse = paymentClient.getPayment(payment);
        //Payment paymetResponse = restTemplate.exchange(ENDPONT_URL, HttpMethod.POST, null, Payment.class);
       response = paymetResponse.getPaymentStatus().equalsIgnoreCase("success")?"payment processing success and order placed":"there is payment failiure";
       orderRepository.save(order);
       return new TransactionResponse(order,paymetResponse.getAmount(),paymetResponse.getTransactionId(),response);
      //  return new TransactionResponse(order,100.0,"wqewqeww",response);
    }
}
