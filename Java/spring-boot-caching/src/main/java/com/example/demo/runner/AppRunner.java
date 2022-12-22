package com.example.demo.runner;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private static final int NUMBER_OF_PRODUCTS = 50;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        int numberOfProducts = NUMBER_OF_PRODUCTS;
        while (numberOfProducts > 0) {
            productRepository.save(new Product("Product " + numberOfProducts, 10 + numberOfProducts));
            numberOfProducts--;
        }
    }

}
