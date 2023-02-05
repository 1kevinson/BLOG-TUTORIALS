package com.example.demo.entity;

import com.example.demo.enums.ProductCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    @NotNull(message = "Category must be specified.")
    private ProductCategory category;

    @Column(name = "description")
    private String description;

    @Min(0)
    @Column(name = "price", columnDefinition = "decimal (10,2)")
    private BigDecimal price;
}
