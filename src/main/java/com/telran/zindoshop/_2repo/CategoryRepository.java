package com.telran.zindoshop._2repo;

import com.telran.zindoshop._1domain.jpa.JpaCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<JpaCategory, Long> {

//   @Transactional
//   void deleteByName(String name);
}
