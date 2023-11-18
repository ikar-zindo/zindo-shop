package com.telran.zindoshop._1domain.interfaces;

import java.sql.Timestamp;

public interface Category {

   long getId();

   String getName();

   String getDescription();

   Timestamp getCreatedAt();

   boolean getAvailable();
}
