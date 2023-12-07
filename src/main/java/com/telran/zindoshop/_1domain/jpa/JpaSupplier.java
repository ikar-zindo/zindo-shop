package com.telran.zindoshop._1domain.jpa;

import com.telran.zindoshop._1domain.interfaces.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;

@Entity
@Table(name = "supplier")
public class JpaSupplier implements Supplier {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "supplier_id")
   private long supplier_id;

   @Column(name = "supplier_name")
   @Pattern(regexp = "^[a-zA-Z0-9\\s\\-_]+$")
   private String supplier_name;

   @Column(name = "contact_name")
   private String contact_name;

   @Column(name = "postal_code")
   private String postal_code;

   @Column(name = "country")
   private String country;

   @Column(name = "address")
   private String address;

   @Column(name = "city")
   private String city;

   @Column(name = "phone")
   private String phone;

   @Column(name = "created_at")
   private Timestamp created_at;

   @Column(name = "available")
   private boolean available;

   public JpaSupplier() {
   }

   public JpaSupplier(String supplier_name, String contact_name, String postal_code,
                      String country, String address, String city, String phone) {

      this.supplier_name = supplier_name;
      this.contact_name = contact_name;
      this.postal_code = postal_code;
      this.country = country;
      this.address = address;
      this.city = city;
      this.phone = phone;

      created_at = new Timestamp(System.currentTimeMillis());
      available = true;
   }

   @Override
   public long getId() {
      return supplier_id;
   }

   @Override
   public String getName() {
      return supplier_name;
   }

   @Override
   public String getContactName() {
      return contact_name;
   }

   @Override
   public String getAddress() {
      return address;
   }

   @Override
   public String getCity() {
      return city;
   }

   @Override
   public String getPostalCode() {
      return postal_code;
   }

   @Override
   public String getCountry() {
      return country;
   }

   @Override
   public String getPhone() {
      return phone;
   }

   @Override
   public Timestamp getCreatedAt() {
      return created_at;
   }

   @Override
   public boolean getAvailable() {
      return available;
   }

   public void setSupplier_id(long supplier_id) {
      this.supplier_id = supplier_id;
   }

   public void setSupplier_name(String supplier_name) {
      this.supplier_name = supplier_name;
   }

   public void setContact_name(String contact_name) {
      this.contact_name = contact_name;
   }

   public void setPostal_code(String postal_code) {
      this.postal_code = postal_code;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public void setCreated_at(Timestamp created_at) {
      this.created_at = created_at;
   }

   public void setAvailable(boolean available) {
      this.available = available;
   }
}
