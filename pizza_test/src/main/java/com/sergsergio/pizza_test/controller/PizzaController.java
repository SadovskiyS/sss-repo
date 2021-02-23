package com.sergsergio.pizza_test.controller;

import com.sergsergio.pizza_test.entity.Pizza;
import com.sergsergio.pizza_test.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/admin/admin-pizza")
    public String pizzaList(Model model) {
        model.addAttribute("allPizzas", pizzaService.allPizzas());
        return "admin-pizza";
    }

    @PostMapping("/admin/admin-pizza")
    public String  deletePizza(@RequestParam(required = true, defaultValue = "" ) Long pizzaId,
                              @RequestParam(required = true, defaultValue = "" ) String actionPizza,
                              Model model) {
        if (actionPizza.equals("deletePizza")){
            pizzaService.deletePizza(pizzaId);
        }
        return "redirect:/admin/admin-pizza";
    }

    @RequestMapping("/admin/admin-pizza/addNewPizza")
    public String addNewPizza(Model model){
        Pizza pizza = new Pizza();
        model.addAttribute("pizza", pizza);
        return "admin-pizza-add";
    }

    @RequestMapping("/admin/admin-pizza/savePizza")
    public String savePizza(@ModelAttribute ("pizza") Pizza pizza){
        pizzaService.savePizza(pizza);
        return "redirect:/admin/admin-pizza";
    }

    @RequestMapping("/admin/admin-pizza/updatePizza")
    public String updatePizza(@RequestParam("pizzaId") Long id, Model model){
        Pizza pizza = pizzaService.findPizzaById(id);
        model.addAttribute("pizza", pizza);
        return "admin-pizza-add";
    }

//    @RequestMapping("/askPizza")
//    public String askPizzaDetails(Model model){
//        model.addAttribute("pizzaNew", new Pizza());
//        return "admin-pizza";
//    }

//    @PostMapping(path = "/admin/admin-pizza")
//    public String showPizzaDetails(@Valid @ModelAttribute("pizzaNew") Pizza pizza, BindingResult result, Model model){
//        if(result.hasErrors()){
//            return "admin-pizza";
//        }
//        if(!pizzaService.savePizza(pizza)){
//            model.addAttribute("pizzaError", "Пицца с таким именем уже существует!");
//            return "admin-pizza";
//        }
//        else{
//            return "redirect:/admin-pizza";
//        }
//    }
}
