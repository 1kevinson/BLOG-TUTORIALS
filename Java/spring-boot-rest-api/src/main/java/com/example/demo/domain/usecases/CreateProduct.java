package com.example.demo.domain.usecases;

import com.example.demo.entity.Product;
import com.example.demo.enums.ProductCategory;

import java.math.BigDecimal;

public class CreateProduct {

    public Product getInput(String description, ProductCategory category, BigDecimal price) {
        return Product.builder()
                .description(description)
                .category(category)
                .price(price)
                .build();
    }
}
