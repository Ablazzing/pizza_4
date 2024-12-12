package com.javaacademy.pizza.controller;

import com.javaacademy.pizza.dto.PizzaDto;
import com.javaacademy.pizza.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/pizza")
@RequiredArgsConstructor
@CrossOrigin
public class PizzaController {
    private final PizzaService pizzaService;

    @GetMapping
    public List<PizzaDto> findAll() {
        return pizzaService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = CREATED)
    public void createPizza(@RequestBody PizzaDto pizzaDto) {
        pizzaService.create(pizzaDto);
    }

}
