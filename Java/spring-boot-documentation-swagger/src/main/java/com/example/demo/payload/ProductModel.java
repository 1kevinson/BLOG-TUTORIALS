package com.example.demo.payload;

import com.example.demo.enums.ProductCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Component
@Schema(
        title = "Product Model",
        description = "Parameter required to create or update a product",
        requiredMode = Schema.RequiredMode.REQUIRED
)
public class ProductModel {

    private ProductCategory category;
    private String description;
    private BigDecimal price;
}
