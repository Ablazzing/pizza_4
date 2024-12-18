package com.javaacademy.pizza.controller;

import com.javaacademy.pizza.dto.OrderDto;
import com.javaacademy.pizza.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public String createNewOrder(Map<String, Integer> orderMap) {

        return orderService.createNewOrder(Map.of("Пицца фирменная", 1));
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

}
