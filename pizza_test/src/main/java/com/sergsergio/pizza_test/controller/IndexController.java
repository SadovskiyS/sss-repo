package com.sergsergio.pizza_test.controller;

import com.sergsergio.pizza_test.entity.Pizza;
import com.sergsergio.pizza_test.service.PizzaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    Logger log = Logger.getLogger(IndexController.class);
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("/")
    public String infoPizza( Model model){
        log.debug("Начало работы метода infoPizza");
        model.addAttribute("allPizzas", pizzaService.allPizzas());
        log.debug("Конец работы метода infoPizza");
        return "index";
    }

    @RequestMapping(value = "/pricePizza", method = RequestMethod.GET)
    @ResponseBody
    public Integer pricePizza(@RequestParam("id") Long pizzaId,
                              @RequestParam("price30") int price30){
        log.debug("Начало работы метода pricePizza");
        price30 = pizzaService.getPrice30SMById(pizzaId);
        log.debug("pricePizza = " + price30);
        log.debug("Конец работы метода pricePizza");
        return price30;
    }

    @RequestMapping(value = "/pricePizza2", method = RequestMethod.GET)
    @ResponseBody
    public Integer pricePizza2(@RequestParam("id") Long pizzaId,
                              @RequestParam("price50") int price50){
        log.debug("Начало работы метода pricePizza2");
        price50 = pizzaService.getPrice50SMById(pizzaId);
        log.debug("pricePizza2 = " + price50);
        log.debug("Конец работы метода pricePizza2");
        return price50;
    }

//-------------------------------------------------работает

//    @RequestMapping(value = "/pricePizza", method = RequestMethod.GET)
//    @ResponseBody
//    public Integer pricePizza(){
//        log.debug("Начало работы метода pricePizza");
//        int pricePizza = pizzaService.getPrice30SMById(1L);
//        log.debug("pricePizza = " + pricePizza);
//        log.debug("Конец работы метода pricePizza");
//        return pricePizza;
//    }
//---------------------------------------------------

}
