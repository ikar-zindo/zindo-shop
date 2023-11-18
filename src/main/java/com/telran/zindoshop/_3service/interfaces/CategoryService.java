package com.telran.zindoshop._3service.interfaces;

import com.telran.zindoshop._1domain.interfaces.Category;

import java.util.List;

public interface CategoryService {

   List<Category> getAll();

   Category getById(long id);

   void add(Category category);

   void deleteById(long id);

//   void deleteByName(String name);

   long getCount();

   double getTotalPrice();

   double getAveragePrice();
}
