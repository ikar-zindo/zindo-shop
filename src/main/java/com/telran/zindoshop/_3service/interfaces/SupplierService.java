package com.telran.zindoshop._3service.interfaces;

import com.telran.zindoshop._1domain.interfaces.Supplier;

import java.util.List;

public interface SupplierService {

   List<Supplier> getAll();

   Supplier getById(long id);

   void add(Supplier supplier);

   long getCount();

   double getTotalPrice();

   double getAveragePrice();

   void deleteById(long id);
}
