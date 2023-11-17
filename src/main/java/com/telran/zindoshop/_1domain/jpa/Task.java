package com.telran.zindoshop._1domain.jpa;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class Task {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "task_id")
   private Long id;

   @Column(name = "description")
   private String description;

   @Column(name = "created_at")
   private Timestamp createdAt;



   public Task() {
      createdAt = new Timestamp(System.currentTimeMillis());
   }

   public Task(String description) {
      this.description = description;
      createdAt = new Timestamp(System.currentTimeMillis());
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Timestamp getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Timestamp createdAt) {
      this.createdAt = createdAt;
   }
}
