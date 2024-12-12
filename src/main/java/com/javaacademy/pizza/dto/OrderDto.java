package com.javaacademy.pizza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Map<String, Integer> pizzaMap;
    private String number;
    private BigDecimal totalPrice;
    private LocalDateTime created = LocalDateTime.now();
}
