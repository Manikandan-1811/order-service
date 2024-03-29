package com.jtech.os.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    private int id;
    private String name;
    private int qty;
    private double price;
}
