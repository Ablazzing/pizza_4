package com.javaacademy.pizza.mapper;

import com.javaacademy.pizza.dto.PizzaDto;
import com.javaacademy.pizza.entity.Pizza;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PizzaMapper {

    public PizzaDto convert(Pizza pizza) {
        return new PizzaDto(pizza.getName(), pizza.getDescription(), pizza.getPrice(), pizza.getImg());
    }
}
