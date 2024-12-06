package com.javaacademy.pizza.repository;

import com.javaacademy.pizza.entity.Order;
import com.javaacademy.pizza.storage.OrderStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepository {
    private final OrderStorage orderStorage;

    public void save(Order order) {
        orderStorage.save(order);
    }
}
