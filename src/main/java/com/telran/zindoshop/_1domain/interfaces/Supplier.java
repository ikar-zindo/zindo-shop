package com.telran.zindoshop._1domain.interfaces;

import java.sql.Timestamp;

public interface Supplier {

   long getId();

   String getName();

   String getContactName();

   String getAddress();

   String getCity();

   String getPostalCode();

   String getCountry();

   String getPhone();

   Timestamp getCreatedAt();

   boolean getAvailable();
}
