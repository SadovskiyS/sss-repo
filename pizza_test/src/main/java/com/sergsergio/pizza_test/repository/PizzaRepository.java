package com.sergsergio.pizza_test.repository;

import com.sergsergio.pizza_test.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByName(String name);
    Long findPizzaByName(String name);
}
