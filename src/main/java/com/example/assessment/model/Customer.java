package com.example.assessment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private Long registrationCode;
  private String fullName;
  private String email;
  private Long telephone;


}
