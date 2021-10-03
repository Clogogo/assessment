package com.example.assessment.controller;

import com.example.assessment.model.Customer;
import com.example.assessment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

  @Autowired private CustomerService customerService;

  // Create a new customer
  @PostMapping("/create/customer")
  public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerService.addCustomer(customer));
  }
}
