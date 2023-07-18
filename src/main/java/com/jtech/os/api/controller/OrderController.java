package com.jtech.os.api.controller;

import com.jtech.os.api.dto.TransactionRequest;
import com.jtech.os.api.dto.TransactionResponse;
import com.jtech.os.api.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing order (Create, List, get, and Delete API).
 * Annotated with {@link RestController @RestController}, {@link RequestMapping @RequestMapping}.
 *
 * @author Manikandan
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        logger.info("Order controller: bookOrder() initiated");
        return service.saveOrder(request);
    }

}
