package com.example.demo.domain;

import com.example.demo.enums.ProductCategory;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductModel {

    private ProductCategory category;
    private String description;
    private BigDecimal price;
}
