package com.sergsergio.pizza_test.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 15, message = "Минимум 5 и максимум 15 символов!")
    private String name;
    @Size(min = 5, max = 70, message = "Минимум 5 и максимум 70 символов!")
    private String descr;
    private int price30SM;
    private int price50SM;
//    @Transient
//    @OneToOne(mappedBy = "pizza")
//    private SizePricePizza sizePricePizza;

    public Pizza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

//    public SizePricePizza getSizePricePizza() {
//        return sizePricePizza;
//    }
//
//    public void setSizePricePizza(SizePricePizza sizePricePizza) {
//        this.sizePricePizza = sizePricePizza;
//    }


    public int getPrice30SM() {
        return price30SM;
    }

    public void setPrice30SM(int price30SM) {
        this.price30SM = price30SM;
    }

    public int getPrice50SM() {
        return price50SM;
    }

    public void setPrice50SM(int price50SM) {
        this.price50SM = price50SM;
    }
}
