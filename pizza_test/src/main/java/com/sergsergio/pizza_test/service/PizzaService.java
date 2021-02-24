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
//    @Autowired
//    SizePriceRepository sizePriceRepository;

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

//    public Long findPizzaIdByName(String name) throws IDNotFoundException {
//        Long id = pizzaRepository.findPizzaByName(name);
//        if(id == null){
//            throw new IDNotFoundException();
//        }
//        return id;
//    }

//    public List<SizePricePizza> allSizeAndPricePizza(){
//        return sizePriceRepository.findAll();
//    }
//
//    public SizePricePizza findSizePricePizzaById(Long id){
//        Optional<SizePricePizza> sizePriceFromDb = sizePriceRepository.findById(id);
//        return sizePriceFromDb.orElse(new SizePricePizza());
//    }
//
//    public boolean saveSizePricePizza(SizePricePizza sizePricePizza, String name) throws IDNotFoundException {
//        Long pizzaId = findPizzaIdByName(name);
//        Optional<SizePricePizza> sizePricePizzaFromDb = sizePriceRepository.findById(pizzaId);
//        sizePricePizza = sizePricePizzaFromDb.orElse(new SizePricePizza());
//        if(sizePricePizza != null){
//            return false;
//        }
//        sizePriceRepository.save(sizePricePizza);
//        return true;
//    }
}
