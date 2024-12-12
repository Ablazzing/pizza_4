package com.javaacademy.pizza.mapper;

import com.javaacademy.pizza.dto.PizzaDto;
import com.javaacademy.pizza.entity.Pizza;
import org.springframework.stereotype.Service;

@Service
public class PizzaMapper {

    public PizzaDto convertToDto(Pizza pizza) {
        return new PizzaDto(pizza.getName(), pizza.getDescription(), pizza.getPrice(), pizza.getImg());
    }

    public Pizza convertToEntity(PizzaDto pizzaDto) {
        return new Pizza(pizzaDto.getName(), pizzaDto.getDescription(), pizzaDto.getPrice(), pizzaDto.getImgUrl());
    }
}
