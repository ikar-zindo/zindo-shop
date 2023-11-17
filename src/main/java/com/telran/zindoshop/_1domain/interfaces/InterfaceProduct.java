package com.telran.zindoshop._1domain.interfaces;

import java.sql.Timestamp;

public interface InterfaceProduct {

   long getId();

   String getName();

   double getPrice();

   String getDescription();

   Timestamp getCreatedAt();

   boolean getAvailable();
}
