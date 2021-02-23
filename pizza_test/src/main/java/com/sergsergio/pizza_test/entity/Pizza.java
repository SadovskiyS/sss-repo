package com.sergsergio.pizza_test.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
}
