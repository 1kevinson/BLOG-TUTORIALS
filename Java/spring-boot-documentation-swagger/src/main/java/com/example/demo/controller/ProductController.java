package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.payload.ErrorResponse;
import com.example.demo.payload.ProductModel;
import com.example.demo.service.ProductService;
import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Tag(name = "Product", description = "Manage Product items")
public class ProductController {

    private final ProductService service;

    @Operation(summary = "Create a new product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json"),
            }, description = "Creation OK"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductModel product) {
        return new ResponseEntity<>(service.create(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve one product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json"),
            }, description = "Creation OK"),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json"),
            }, description = "Product not found"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json"),
            }, description = "OK"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Update a product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json"),
            }, description = "Update OK"),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json"),
            }, description = "Product doesn't exist"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateOneProduct(@PathVariable("id") int id, @RequestBody ProductModel product) {
        service.updateOne(id, product);
    }

    @Operation(summary = "Update partially a product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = JsonPatch.class), mediaType = "application/json"),
            }, description = "Patch OK"),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json"),
            }, description = "Product doesn't exist"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @PatchMapping(value = "/update/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Product> patchOneProduct(@PathVariable("id") int id, @RequestBody JsonPatch patch) {
        return new ResponseEntity<>(service.patchOne(id, patch),HttpStatus.OK);
    }

    @Operation(summary = "Delete a product")
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = {
                    @Content(schema = @Schema(implementation = Product.class), mediaType = "application/json"),
            }, description = "Delete OK"),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json"),
            }, description = "Product doesn't exist"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public void deleteOneProduct(@PathVariable("id") int id) {
        service.deleteById(id);
    }

    @Operation(summary = "Delete all products")
    @ApiResponses({
            @ApiResponse(responseCode = "205", content = {
                    @Content(schema = @Schema())}, description = "Delete all OK"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
            }, description = "Internal server error")
    })
    @DeleteMapping()
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteAllProducts() {
        service.deleteAll();
    }
}
