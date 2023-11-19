package com.telran.zindoshop._3service.jpa;

import com.telran.zindoshop._1domain.interfaces.Product;
import com.telran.zindoshop._1domain.interfaces.Supplier;
import com.telran.zindoshop._1domain.jpa.JpaProduct;
import com.telran.zindoshop._1domain.jpa.JpaSupplier;
import com.telran.zindoshop._2repo.ProductRepository;
import com.telran.zindoshop._2repo.SupplierRepository;
import com.telran.zindoshop._3service.interfaces.ProductService;
import com.telran.zindoshop._3service.interfaces.SupplierService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaSupplierService implements SupplierService {

   private final Logger LOGGER = LogManager.getLogger(JpaSupplierService.class);

   private SupplierRepository repository;

   public JpaSupplierService(SupplierRepository repository) {
      this.repository = repository;
   }

   @Override
   public List<Supplier> getAll() {
      return new ArrayList<>(repository.findAll());
   }

   @Override
   public Supplier getById(long id) {
      return repository.findById(id).orElse(null);
   }

   @Override
   public void add(Supplier supplier) {
      repository.save(new JpaSupplier(supplier.getName(), supplier.getContactName(), supplier.getPostalCode(),
              supplier.getCountry(), supplier.getAddress(), supplier.getCity(), supplier.getPhone()));
   }

   @Override
   public void deleteById(long id) {
      repository.deleteById(id);
   }

   @Override
   public long getCount() {
      return repository.count();
   }


   // todo: реализовать карректный вывод общей стоимости и срелней цены товаров одной категории
   @Override
   public double getTotalPrice() {
      return 0;
   }

   @Override
   public double getAveragePrice() {
      return 0;
   }
}
