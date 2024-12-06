package com.javaacademy.pizza.storage;

import com.javaacademy.pizza.entity.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PizzaStorage {
    private final Map<String, Pizza> data = new HashMap<>();

    public void save(Pizza pizza) {
        data.put(pizza.getName(), pizza);
    }

    public List<Pizza> findAll() {
        return new ArrayList<>(data.values());
    }
}
