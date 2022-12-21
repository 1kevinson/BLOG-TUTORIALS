package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Cacheable("products")
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Cacheable(value = "products", key = "#id")
    public Product getProductById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @CachePut(value = "products", key = "#product.id")
    public Product updateOneProduct(Product product) {
        return repository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteOneProduct(int id) {
        repository.deleteById(id);
    }

    @CacheEvict(value = "products", allEntries = true)
    public void deleteAllProducts() {
        repository.deleteAll();
    }

}
