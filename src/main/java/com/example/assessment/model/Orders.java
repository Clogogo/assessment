package com.example.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Orders {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @OneToOne private Customer customer;

  private Long quantity;
  private String dateCreated;

  @OneToOne
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Product product;

  public Orders(Long id, Customer customer, Product product, Long quantity, String dateCreated) {
    this.id = id;
    this.customer = customer;
    this.dateCreated = Orders.dateCreated();
    this.product = product;
    this.quantity = quantity;
  }

  public Orders(Long id, Customer customer, Product product, Long quantity) {
    this.id = id;
    this.customer = customer;
    this.dateCreated = Orders.dateCreated();
    this.product = product;
    this.quantity = quantity;
  }

  public static String dateCreated() {
    DateTimeFormatter formatter =
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.UK)
            .withZone(ZoneId.systemDefault());

    Instant instant = Instant.now();
    String date = formatter.format(instant);
    return date.substring(0, 10);
  }



}
