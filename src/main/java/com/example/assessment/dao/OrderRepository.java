package com.example.assessment.dao;

import com.example.assessment.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

  List<Orders> findAllByDateCreated(String dateCreated);

  List<Orders> findAllByCustomerId(Long customerId);

  List<Object> findAllByProductId(Long productId);

}
