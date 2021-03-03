package com.sergsergio.pizza_test.repository;

import com.sergsergio.pizza_test.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByName(String name);
    @Query("select price30SM from Pizza p where p.id =:id")
    int getPrice30SMById(@Param("id") Long id);
    @Query("select price50SM from Pizza p where p.id =:id")
    int getPrice50SMById(@Param("id") Long id);
}
