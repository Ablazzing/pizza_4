package com.javaacademy.pizza.service;

import com.javaacademy.pizza.dto.PizzaDto;
import com.javaacademy.pizza.entity.Pizza;
import com.javaacademy.pizza.mapper.PizzaMapper;
import com.javaacademy.pizza.repository.PizzaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    @PostConstruct
    public void init() {

    }

    public List<PizzaDto> findAll() {
        return pizzaRepository.findAll().stream()
                .map(pizzaMapper::convertToDto)
                .toList();
        //{
        //    'name': 'Пицца фирменная',
        //    'price': 700,
        //    'description': 'Со вкусом ветчины, грибов и сыра',
        //    'img_url': 'https://papajohns.ru/assets/cover.a41b9c9b.png'
        //}
    }

    public void create(PizzaDto pizzaDto) {
        Pizza pizza = pizzaMapper.convertToEntity(pizzaDto);
        pizzaRepository.save(pizza);
    }
}
