package com.telran.zindoshop.controllers;

import com.telran.zindoshop.models.Product;
import com.telran.zindoshop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

   @Autowired
   private ProductRepository productRepository;


   @GetMapping("/product")
   public String getAll(Model model) {
      Iterable<Product> products = productRepository.findAll();
      model.addAttribute("products", products);
      return "product";
   }

   @GetMapping("/product/add")
   public String addProductForm(Model model) {
      return "product-add";
   }

   @PostMapping("/product/add")
   public String addProductAction(@RequestParam String product_name,
                                  @RequestParam String unit,
                                  @RequestParam Double price) {
      Product product = new Product(product_name, unit, price);
      productRepository.save(product);
      return "redirect:/product";
   }

}
