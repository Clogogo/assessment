package com.example.assessment.controller;

import com.example.assessment.model.Orders;
import com.example.assessment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

  @Autowired private OrderService orderService;

  // Get request search order by date
  @GetMapping("/order/search/date")
  public ResponseEntity<?> searchOrderByDate(@RequestParam("Date") String dateCreated) {
    return new ResponseEntity<>(orderService.searchOrderByDate(dateCreated), HttpStatus.OK);
  }

  // Search All order by customer id
  @GetMapping("/order/customer/all")
  public ResponseEntity<?> getAllOrderIds(@RequestParam("customerId") Long customerId) {
    return new ResponseEntity<>((orderService.getCustomersOrders(customerId)), HttpStatus.OK);
  }

  // Search Orders by product id
  @GetMapping("/order/product/all")
  public ResponseEntity<?> getOrderByProduct(@RequestParam("productId") Long productId) {
    return new ResponseEntity<>(orderService.getProductOrders(productId), HttpStatus.OK);
  }

  // Create a new orderItems
  @PostMapping("/order/create/{customerId}/{productId}/")
  public ResponseEntity<?> createCustomer(
      @RequestBody Orders orders,
      @PathVariable("customerId") Long customerId,
      @PathVariable("productId") Long productId) {
    Orders result = orderService.addOrder(orders.getQuantity(), customerId, productId);
    if (result == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
    return ResponseEntity.ok(orderService.addOrder(orders.getQuantity(), customerId, productId));
  }

  // change quantity of a products in all order line with order id
  @PutMapping("/order/product/quantity/{orderId}")
  public ResponseEntity<?> changeQuantityOfProduct(
      @RequestBody Orders orders, @PathVariable("orderId") Long orderId) {
    return orderService.changeQuantityOfProduct(orderId, orders.getQuantity());
  }
}
