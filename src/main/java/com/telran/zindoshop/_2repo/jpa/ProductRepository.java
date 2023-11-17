package com.telran.zindoshop._2repo.jpa;

import com.telran.zindoshop._1domain.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
