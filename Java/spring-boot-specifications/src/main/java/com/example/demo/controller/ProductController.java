package com.example.demo.controller;

import com.example.demo.payload.ProductModel;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductModel product) {
        return new ResponseEntity<>(service.create(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOneProduct(@PathVariable("id") int id, @RequestBody ProductModel product) {
        service.updateOne(id, product);
    }

    @PatchMapping(value = "/update/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Product> patchOneProduct(@PathVariable("id") int id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(service.patchOne(id, patch),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneProduct(@PathVariable("id") int id) {
        service.deleteById(id);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProducts() {
        service.deleteAll();
    }
}
