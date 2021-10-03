package com.example.assessment.service;

import com.example.assessment.dao.ProductRepository;
import com.example.assessment.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

  @Autowired ProductRepository productRepository;

  // Add customer by Product parameter
  public Product addProduct(Product product) {
    return productRepository.save(product);

  }



}
