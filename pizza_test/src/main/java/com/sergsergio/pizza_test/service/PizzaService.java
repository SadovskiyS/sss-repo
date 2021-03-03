package com.sergsergio.pizza_test.service;

import com.sergsergio.pizza_test.entity.Pizza;
import com.sergsergio.pizza_test.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    List<Pizza> pizzaList = new ArrayList<>();
    public Pizza findPizzaById(Long id){
        Optional<Pizza> pizzaFromDb = pizzaRepository.findById(id);
        return pizzaFromDb.orElse(new Pizza());
    }

    public List<Pizza> allPizzas(){
        pizzaList = pizzaRepository.findAll();
        return pizzaList;
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

    public int getPrice30SMById(Long pizza_id){
        return pizzaRepository.getPrice30SMById(pizza_id);
    }

    public int getPrice50SMById(Long pizza_id){
        return pizzaRepository.getPrice50SMById(pizza_id);
    }
}
