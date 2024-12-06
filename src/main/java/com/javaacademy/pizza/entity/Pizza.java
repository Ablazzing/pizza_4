package com.javaacademy.pizza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Pizza {
    private String name;
    private String description;
    private BigDecimal price;
    private String img;
}
