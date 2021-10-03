package com.example.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;
  private Long skuCode;
  private Long unitPrice;


}
