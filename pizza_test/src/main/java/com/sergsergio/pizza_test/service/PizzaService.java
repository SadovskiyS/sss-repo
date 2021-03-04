package com.sergsergio.pizza_test.service;

import com.sergsergio.pizza_test.entity.Pizza;
import com.sergsergio.pizza_test.repository.PizzaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    Logger log = Logger.getLogger(PizzaService.class);
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

    public boolean savePizza(Pizza pizza, @RequestParam("file") MultipartFile file){
        log.debug("Начало метода savePizza в PizzaService");
        Pizza pizzaFromDb = pizzaRepository.findByName(pizza.getName());
        log.debug("savePizza в PizzaService: поиск пиццы = " + pizzaFromDb);
//        if(pizzaFromDb != null){
//            log.debug("savePizza в PizzaService: pizzaFromDb != null");
//            return false;
//        }
        log.debug("savePizza в PizzaService: pizzafromDB not null, will be getting filename...");
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            log.debug("Not a valid file");
        }
        log.debug("savePizza в PizzaService: filename is - " + fileName);
        try {
            pizza.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        pizzaRepository.save(pizza);
        log.debug("Конец метода savePizza в PizzaService");
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
