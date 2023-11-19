package com.telran.zindoshop._1domain.jpa;

import com.telran.zindoshop._1domain.interfaces.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;

@Entity
@Table(name = "category")
public class JpaCategory implements Category {

   /**
    * проблема с копировинием имени
    * возможно какае-то буква в другой раскладке
    * нужно явно скопировать слово
    */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "category_id")
   private long category_id;

   @Column(name = "category_name")
   @Pattern(regexp = "^[a-zA-Z0-9\\s\\-_]+$")
   private String category_name;

   @Column(name = "description")
   private String description;

   @Column(name = "created_at")
   private Timestamp created_at;

   @Column(name = "available")
   private boolean available;

   public JpaCategory() {
   }

   public JpaCategory(String category_name) {
      this.category_name = category_name;
      created_at = new Timestamp(System.currentTimeMillis());
      available = true;
   }

   public JpaCategory(String category_name, String description) {
      if (description == null)
         this.description = null;

      this.category_name = category_name;
      this.description = description;
      created_at = new Timestamp(System.currentTimeMillis());
      available = true;
   }


   @Override
   public long getId() {
      return category_id;
   }

   @Override
   public String getName() {
      return category_name;
   }

   @Override
   public String getDescription() {
      return description;
   }

   @Override
   public Timestamp getCreatedAt() {
      return created_at;
   }

   @Override
   public boolean getAvailable() {
      return available;
   }

   public void setCategory_id(long category_id) {
      this.category_id = category_id;
   }

   public void setCategory_name(String category_name) {
      this.category_name = category_name;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setCreated_at(Timestamp created_at) {
      this.created_at = created_at;
   }

   public boolean isAvailable() {
      return available;
   }

   public void setAvailable(boolean available) {
      this.available = available;
   }
}
