package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.jpa.JpaProduct;
import com.telran.zindoshop._2repo.ProductRepository;
import com.telran.zindoshop._3service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

   @Autowired
   private ProductRepository productRepository;

   @Autowired
   private ProductService service;

   @GetMapping("/dashboard")
   public String getAll(Model model) {
      Iterable<JpaProduct> products = productRepository.findAll();

      long count = service.getCount();
      double totalPrice = service.getTotalPrice();
      double avgPrice = service.getAveragePrice();

      model.addAttribute("products", products);
      model.addAttribute("count", count);
      model.addAttribute("totalPrice", totalPrice);
      model.addAttribute("avgPrice", avgPrice);


      return "dashboard";
   }
}
