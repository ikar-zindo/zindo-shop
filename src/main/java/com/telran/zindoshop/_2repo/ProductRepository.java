package com.telran.zindoshop._2repo;

import com.telran.zindoshop._1domain.jpa.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<JpaProduct, Long> {
}
