package com.telran.zindoshop._1domain.interfaces;

import java.sql.Timestamp;

public interface Product {

   long getId();

   String getName();

   String getUnit();

   double getPrice();

   String getDescription();

   Timestamp getCreatedAt();

   boolean getAvailable();
}
