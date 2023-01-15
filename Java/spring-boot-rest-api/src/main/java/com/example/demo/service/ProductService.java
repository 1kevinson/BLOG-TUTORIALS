package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Product updateOneProduct(Product product) {
        return repository.save(product);
    }

    public void deleteOneProduct(long id) {
        repository.deleteById(id);
    }

    public void deleteAllProducts() {
        repository.deleteAll();
    }

}
