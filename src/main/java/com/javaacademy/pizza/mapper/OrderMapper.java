package com.javaacademy.pizza.mapper;

import com.javaacademy.pizza.dto.OrderDto;
import com.javaacademy.pizza.entity.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class OrderMapper {

    public OrderDto convertToDto(Order order) {
        return new OrderDto(new HashMap<>(order.getPizzaMap()), order.getNumber(), order.getTotalPrice(), order.getCreated());
    }
}
