package com.telran.zindoshop.test;

import com.telran.zindoshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
