package com.telran.zindoshop._3service.jpa;

import com.telran.zindoshop._1domain.interfaces.Product;
import com.telran.zindoshop._1domain.jpa.JpaProduct;
import com.telran.zindoshop._2repo.CategoryRepository;
import com.telran.zindoshop._2repo.ProductRepository;
import com.telran.zindoshop._2repo.SupplierRepository;
import com.telran.zindoshop._3service.interfaces.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaProductService implements ProductService {

   private final Logger LOGGER = LogManager.getLogger(JpaProductService.class);

   private ProductRepository productRepository;

   private CategoryRepository categoryRepository;

   private SupplierRepository supplierRepository;


   public JpaProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
      this.productRepository = productRepository;
      this.categoryRepository = categoryRepository;
   }

   @Override
   public List<Product> getAll() {
      return new ArrayList<>(productRepository.findAll());
   }

   @Override
   public Product getById(long id) {
      return productRepository.findById(id).orElse(null);
   }

   @Override
   public void add(Product product) {

      JpaProduct savedProduct = productRepository.save(new JpaProduct(product.getName(),
              product.getUnit(), product.getPrice(), product.getCategoryId(),
              product.getSupplierId(), product.getDescription(), product.getAvailable()));
   }

   @Override
   public void deleteById(long id) {
      productRepository.deleteById(id);
   }

   @Override
   public long getCount() {
      return productRepository.count();
   }

   @Override
   public double getTotalPrice() {
      return productRepository.findAll().stream()
              .mapToDouble(JpaProduct::getPrice)
              .sum();
   }


   @Override
   public double getAveragePrice() {
      double avgPrice = productRepository.findAll().stream()
              .mapToDouble(JpaProduct::getPrice)
              .average()
              .orElse(-1);

      return Math.round(avgPrice * 100.0) / 100.0;
   }

   /**
    * В этом примере метод updateProduct() помечен аннотацией @Transactional,
    * поэтому ВСЕ ОПЕРАЦИИ с Product будут выполнены в рамках одной транзакции.
    */
}
