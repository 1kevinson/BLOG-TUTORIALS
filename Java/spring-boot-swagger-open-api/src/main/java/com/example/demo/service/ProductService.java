package com.example.demo.service;

import com.example.demo.payload.ProductModel;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(ProductModel product) {
        var productToSave = Product.builder()
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();

        return repository.save(productToSave);
    }

    public Product findById(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Product> findAll() {
        return repository.findAll().stream().sorted(Comparator.comparing(Product::getId)).toList();
    }

    public void updateOne(long id, ProductModel product) {
        if (repository.findById(id).isEmpty()) throw new EntityNotFoundException();
        repository.updateById(product.getDescription(), product.getCategory().toString(), product.getPrice(), id);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
