package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
      return new ResponseEntity<>( service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("id") int id) {
        return new ResponseEntity<>( service.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateOneProduct(@RequestBody Product product) {
        return new ResponseEntity<>( service.updateOneProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneProduct(@PathVariable("id") int id) {
        service.deleteOneProduct(id);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProducts() {
        service.deleteAllProducts();
    }

}
