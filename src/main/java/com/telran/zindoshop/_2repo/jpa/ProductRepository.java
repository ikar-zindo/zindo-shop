package com.telran.zindoshop._2repo.jpa;

import com.telran.zindoshop._1domain.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
