package com.example.assessment.service;

import com.example.assessment.dao.CustomerRepository;
import com.example.assessment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

  @Autowired CustomerRepository customerRepository;

  // Add customer by customer parameter
  public Customer addCustomer(Customer customer) {
    return customerRepository.save(customer);
  }
}
