package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    public Product() {}

    public Product(String description, int price) {
        this.description = description;
        this.price = price;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @Min(0)
    private int price;

}
