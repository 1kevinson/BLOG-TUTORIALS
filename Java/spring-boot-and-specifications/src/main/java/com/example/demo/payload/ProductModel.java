package com.example.demo.payload;

import com.example.demo.enums.ProductCategory;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Component
public class ProductModel {

    private ProductCategory category;
    private String description;
    private BigDecimal price;
}
