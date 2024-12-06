package com.javaacademy.pizza.service;

import com.javaacademy.pizza.dto.PizzaDto;
import com.javaacademy.pizza.entity.Order;
import com.javaacademy.pizza.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final PizzaService pizzaService;
    private final OrderRepository orderRepository;
    private final NumberGenerator numberGenerator;

    public String createNewOrder(Map<String, Integer> orderMap) {
        Order order = new Order();
        order.setPizzaMap(orderMap);
        List<PizzaDto> pizzaDtos = pizzaService.findAll();
        order.setTotalPrice(calculateTotalPrice(orderMap, pizzaDtos));
        order.setNumber(numberGenerator.generateNumber());
        orderRepository.save(order);
        return order.getNumber();
    }

    private BigDecimal calculateTotalPrice(Map<String, Integer> orderMap, List<PizzaDto> pizzaDtos) {
        //name - price
        Map<String, BigDecimal> pizzaPrices = pizzaDtos.stream()
                .collect(Collectors.toMap(PizzaDto::getName, PizzaDto::getPrice));
        BigDecimal result = BigDecimal.ZERO;

        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String pizzaNameFromReq = entry.getKey();
            Integer pizzaCountFromReq = entry.getValue();
            if (!pizzaPrices.containsKey(pizzaNameFromReq)) {
                throw new RuntimeException("Пиццы нет с таким именем");
            }
            result = result.add(pizzaPrices.get(pizzaNameFromReq).multiply(BigDecimal.valueOf(pizzaCountFromReq)));
        }

        return result;
    }
}
