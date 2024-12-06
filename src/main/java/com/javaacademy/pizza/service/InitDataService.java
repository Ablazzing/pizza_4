package com.javaacademy.pizza.service;

import com.javaacademy.pizza.entity.Pizza;
import com.javaacademy.pizza.repository.PizzaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.math.BigDecimal.valueOf;

@Service
@Profile("first")
@RequiredArgsConstructor
public class InitDataService {
    private final PizzaRepository pizzaRepository;

    @PostConstruct
    public void init() {
        Pizza pizza1 = new Pizza(
                "Пицца фирменная",
                "Со вкусом ветчины, грибов и сыра",
                valueOf(700),
                "https://papajohns.ru/assets/cover.a41b9c9b.png");
        Pizza pizza2 = new Pizza(
                "Пицца запеченая",
                "Со вкусом салями, сыра и томатов",
                valueOf(400),
                "https://storage.yandexcloud.net/pjproduction/images/catalog/thumbs/cart/Johns-Favorite-Traditional.jpg"
        );
        Pizza pizza3 = new Pizza(
                "Пицца с креветкой",
                "Креветки, сыр и кусочки перца. Что еще надо для счастья?",
                valueOf(500),
                "https://storage.yandexcloud.net/pjproduction/images/catalog/thumbs/cart/65c4b9a021952d7eff9051e723a07d69.jpg");

        pizzaRepository.saveAll(List.of(pizza1, pizza2, pizza3));
    }

}
