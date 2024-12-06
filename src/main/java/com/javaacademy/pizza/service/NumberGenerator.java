package com.javaacademy.pizza.service;

import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {
    private int counter = 0;

    public String generateNumber() {
        counter++;
        return "AA%s".formatted(counter);
    }
}
