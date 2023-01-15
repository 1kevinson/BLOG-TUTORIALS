package com.example.demo.entity;

import com.example.demo.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
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
    private int price;
}
