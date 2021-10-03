package com.example.assessment.service;

import com.example.assessment.dao.OrderRepository;
import com.example.assessment.dao.CustomerRepository;
import com.example.assessment.dao.ProductRepository;
import com.example.assessment.model.Customer;
import com.example.assessment.model.Orders;
import com.example.assessment.model.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class OrderService {
  @Autowired ProductRepository productRepository;
  @Autowired CustomerRepository customerRepository;
  @Autowired OrderRepository orderRepository;

  // Add Order by Order parameter
  public Orders addOrder(Long quantity, Long customerId, Long productId) {
    Customer customer = customerRepository.getById(customerId);
    Product product = productRepository.getById(productId);
    if (customer.getFullName().isEmpty() || product.getName().isEmpty()) {
      return null;
    } else {
      return orderRepository.save(
          new Orders(null, customer, product, quantity, Orders.dateCreated()));
    }
  }

  // Get Customer Order by customerId
  public List<Orders> getCustomersOrders(Long customerId) {
    return orderRepository.findAllByCustomerId(customerId);
  }

  // search all order by date
  public List<Orders> searchOrderByDate(String date) {
    return orderRepository.findAllByDateCreated(formatDate(date));
  }

  // utility method format Date
  String formatDate(@NotNull String date) {
    return date.replace("-", "/");
  }

  //
  public List<Object> getProductOrders(Long productId) {
    return orderRepository.findAllByProductId(productId);
  }

  // Change quantity of a product in an order line
  public ResponseEntity<?> changeQuantityOfProduct(Long productId, Long quantity) {
    orderRepository
        .findById(productId)
        .ifPresentOrElse(
            changeQuantityOfProduct -> {
              changeQuantityOfProduct.setQuantity(quantity);
              orderRepository.save(changeQuantityOfProduct);
            },
            () -> {
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product Not Found");
            });
    return null;
  }
}
