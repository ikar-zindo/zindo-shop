package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.jpa.Product;
import com.telran.zindoshop._2repo.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

   @Autowired
   private ProductRepository productRepository;

   @GetMapping("/")
   public String getAll(Model model) {
      Iterable<Product> products = productRepository.findAll();
      model.addAttribute("products", products);
      return "dashboard";
   }
}
