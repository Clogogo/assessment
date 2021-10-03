package com.example.assessment.controller;

import com.example.assessment.model.Product;
import com.example.assessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

  @Autowired private ProductService productService;

  // Create a new customer
  @PostMapping("/create/product")
  public ResponseEntity<Product> createCustomer(@RequestBody Product product) {
    return ResponseEntity.ok(productService.addProduct(product));
  }
}
