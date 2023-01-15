package com.example.demo.entity;

import com.example.demo.enums.ProductCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@Table(name = "product")
public class Product extends BaseEntity {

    public Product() {}

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "category",nullable = false, columnDefinition = "field could be null, default 'UNKNOWN'")
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Column(name = "description")
    private String description;

    @Min(0)
    @Column(name = "price")
    private BigDecimal price;
}
