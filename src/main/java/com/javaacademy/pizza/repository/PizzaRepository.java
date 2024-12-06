package com.javaacademy.pizza.repository;

import com.javaacademy.pizza.entity.Pizza;
import com.javaacademy.pizza.storage.PizzaStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PizzaRepository {
    private final PizzaStorage pizzaStorage;

    public void save(Pizza pizza) {
        pizzaStorage.save(pizza);
    }

    public void saveAll(List<Pizza> pizzas) {
        pizzas.forEach(this::save);
    }

    public List<Pizza> findAll() {
        return pizzaStorage.findAll();
    }

}
