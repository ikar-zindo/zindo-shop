package com.telran.zindoshop._3service.jpa;

import com.telran.zindoshop._1domain.interfaces.Category;
import com.telran.zindoshop._1domain.jpa.JpaCategory;
import com.telran.zindoshop._2repo.CategoryRepository;
import com.telran.zindoshop._3service.interfaces.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaCategoryService implements CategoryService {

   private final Logger LOGGER = LogManager.getLogger(JpaCategoryService.class);

   private CategoryRepository repository;

   public JpaCategoryService(CategoryRepository repository) {
      this.repository = repository;
   }

   @Override
   public List<Category> getAll() {
      return new ArrayList<>(repository.findAll());
   }

   @Override
   public Category getById(long id) {
      return repository.findById(id).orElse(null);
   }

   @Override
   public void add(Category category) {
      repository.save(new JpaCategory(category.getName(), category.getDescription()));
   }

   @Override
   public void deleteById(long id) {
      repository.deleteById(id);
   }

//   @Override
//   public void deleteByName(String name) {
//      repository.deleteByName(name);
//   }

   @Override
   public long getCount() {
      return repository.count();
   }

   @Override
   public double getTotalPrice() {
      return 0;
   }

   @Override
   public double getAveragePrice() {
      return 0;
   }
}
