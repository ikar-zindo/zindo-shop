package com.telran.zindoshop.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "product_id")
   private Long product_id;
   @Column(name = "product_name")
   private String product_name;
   @Column(name = "unit")
   private String unit;
   @Column(name = "price")
   private Double price;
   @Column(name = "description")
   private String description;
   @Column(name = "created_at")
   private Timestamp created_at;
   @Column(name = "available")
   private Boolean available;


   public Product() {
   }

   public Product(String product_name, String unit, Double price, String description) {
      this.product_name = product_name;
      this.unit = unit;
      this.price = price;
      this.description = description;
   }

   public Long getProduct_id() {
      return product_id;
   }

   public void setProduct_id(Long product_id) {
      this.product_id = product_id;
   }

   public String getProduct_name() {
      return product_name;
   }

   public void setProduct_name(String product_name) {
      this.product_name = product_name;
   }

   public String getUnit() {
      return unit;
   }

   public void setUnit(String unit) {
      this.unit = unit;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Timestamp getCreated_at() {
      return created_at;
   }

   public void setCreated_at(Timestamp created_at) {
      this.created_at = created_at;
   }

   public Boolean getAvailable() {
      return available;
   }

   public void setAvailable(Boolean available) {
      this.available = available;
   }
}
