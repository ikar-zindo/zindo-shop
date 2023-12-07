package com.telran.zindoshop._1domain.jpa;

import com.telran.zindoshop._1domain.interfaces.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "product")
public class JpaProduct implements Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "product_id")
   private Long product_id;

   @Column(name = "product_name")
   @Pattern(regexp = "^[a-zA-Z0-9\\s\\-_]+$")
   private String product_name;

   @Column(name = "unit")
   private String unit;

   @Column(name = "price", columnDefinition = "DOUBLE DEFAULT 0.01")
   @DecimalMin(value = "0.01")
   @DecimalMax(value = "999999.99")
   private Double price;

   // todo: прописать связи между таблицами используя JPA
   @Column(name = "supplier_id")
   private Long supplier_id;

   public Long getSupplier_id() {
      return supplier_id;
   }

   public void setSupplier_id(Long supplier_id) {
      this.supplier_id = supplier_id;
   }

   public Long getCategory_id() {
      return category_id;
   }

   public void setCategory_id(Long category_id) {
      this.category_id = category_id;
   }

   @Column(name = "category_id")
   private Long category_id;

   @Column(name = "description")
   private String description;

   @Column(name = "created_at")
   private Timestamp created_at;

   @Column(name = "available")
   private Boolean available;

   public JpaProduct() {
   }

   public JpaProduct(String product_name, String unit,
                     Double price, Long categoryId,
                     Long supplierId, String description,
                     boolean available) {
      if (price == null) {
         price = 0.01;
      }

      this.product_name = product_name;
      this.unit = unit;
      this.price = price;
      this.category_id = categoryId;
      this.supplier_id = supplierId;
      this.description = description;
      created_at = Timestamp.from(Instant.now());
      this.available = available;
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

   @Override
   public long getId() {
      return product_id;
   }

   @Override
   public String getName() {
      return product_name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public String getDescription() {
      return description;
   }

   @Override
   public Timestamp getCreatedAt() {
      return null;
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

   public boolean getAvailable() {
      return available != null ? available.booleanValue() : false;
   }

   @Override
   public long getCategoryId() {
      return category_id;
   }

   @Override
   public long getSupplierId() {
      return supplier_id;
   }

   public void setAvailable(Boolean available) {
      this.available = available;
   }
}
