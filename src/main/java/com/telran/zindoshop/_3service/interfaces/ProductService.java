package com.telran.zindoshop._3service.interfaces;

import com.telran.zindoshop._1domain.interfaces.Product;

import java.util.List;

public interface ProductService {

   List<Product> getAll();

   Product getById(long id);

   void add(Product product);

   void deleteById(long id);

   long getCount();

   double getTotalPrice();

   double getAveragePrice();
}
