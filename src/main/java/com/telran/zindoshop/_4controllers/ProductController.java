package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.jpa.Product;
import com.telran.zindoshop._2repo.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

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
                                  @RequestParam Double price,
                                  @RequestParam String description,
                                  Model model) {
      Product product = new Product(product_name, unit, price, description);
      Timestamp currentTime = new Timestamp(System.currentTimeMillis());
      product.setCreated_at(currentTime);
      productRepository.save(product);
      return "redirect:/product";
   }

   @GetMapping("/product/{id}")
   public String productInfo(@PathVariable(value = "id") long id, Model model) {
      if (!productRepository.existsById(id)) {
         return "redirect:/product";
      }

      Optional<Product> product = productRepository.findById(id);
      ArrayList<Product> products = new ArrayList<>();
      product.ifPresent(products::add);
      model.addAttribute("product", products);
      return "product-info";
   }

   @GetMapping("/product/{id}/edit")
   public String productEdit(@PathVariable(value = "id") long id, Model model) {
      if (!productRepository.existsById(id)) {
         return "redirect:/product";
      }

      Optional<Product> product = productRepository.findById(id);
      ArrayList<Product> products = new ArrayList<>();
      product.ifPresent(products::add);
      model.addAttribute("product", products);
      return "product-edit";
   }

   @PostMapping("/product/{id}/edit")
   public String productUpdate(@PathVariable(value = "id") long id,
                               @RequestParam String product_name,
                               @RequestParam String unit,
                               @RequestParam Double price,
                               @RequestParam String description,
                               Model model) {
      Product product = productRepository.findById(id).orElseThrow();

      product.setProduct_name(product_name);
      product.setUnit(unit);
      product.setPrice(price);
      product.setDescription(description);
      productRepository.save(product);

      return "redirect:/product";
   }

   @PostMapping("/product/{id}/remove")
   public String productDelete(@PathVariable(value = "id") long id,
                               Model model) {
      Product product = productRepository.findById(id).orElseThrow();
      product.setProduct_name(product.getProduct_name());
      productRepository.delete(product);

      return "redirect:/product";
   }
}
