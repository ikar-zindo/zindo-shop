package com.telran.zindoshop.repo;

import com.telran.zindoshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
