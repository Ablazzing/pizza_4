package com.javaacademy.pizza.storage;

import com.javaacademy.pizza.entity.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderStorage {
    private final Map<String, Order> data = new HashMap<>();

    public void save(Order order) {
        if (data.containsKey(order.getNumber())) {
            throw new RuntimeException("Заказ с таким номером уже есть");
        }
        data.put(order.getNumber(), order);
    }


}
