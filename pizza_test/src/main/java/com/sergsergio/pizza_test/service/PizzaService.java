package com.sergsergio.pizza_test.service;

import com.sergsergio.pizza_test.entity.Pizza;
import com.sergsergio.pizza_test.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    public Pizza findPizzaById(Long id){
        Optional<Pizza> pizzaFromDb = pizzaRepository.findById(id);
        return pizzaFromDb.orElse(new Pizza());
    }

    public List<Pizza> allPizzas(){
        return pizzaRepository.findAll();
    }

    public boolean savePizza(Pizza pizza){
        Pizza pizzaFromDb = pizzaRepository.findByName(pizza.getName());
        if(pizzaFromDb != null){
            return false;
        }
        pizzaRepository.save(pizza);
        return true;
    }

    public boolean deletePizza(Long pizza_Id){
        if(pizzaRepository.findById(pizza_Id).isPresent()){
            pizzaRepository.deleteById(pizza_Id);
            return true;
        }
        return false;
    }
}
