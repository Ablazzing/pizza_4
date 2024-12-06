package com.javaacademy.pizza.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class Order {
    private Map<String, Integer> pizzaMap;
    private String number;
    private BigDecimal totalPrice;
    private LocalDateTime created = LocalDateTime.now();
}
