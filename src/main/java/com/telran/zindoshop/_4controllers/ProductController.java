package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.interfaces.Product;
import com.telran.zindoshop._1domain.jpa.JpaProduct;
import com.telran.zindoshop._3service.jpa.JpaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class ProductController {

   @Autowired
   private JpaProductService service;


   @GetMapping("/product")
   public String getAll(Model model) {
      Iterable<Product> products = service.getAll();
      model.addAttribute("products", products);

      return "product";
   }


   /**
    *
    * @param model
    * @return
    */
   @GetMapping("/product/add")
   public String addProductForm(Model model) {
      return "product-add";
   }


   /**
    *
    * @param product_name
    * @param unit
    * @param price
    * @param description
    * @param model
    * @return
    */
   @PostMapping("/product/add")
   public String addProductAction(@RequestParam String product_name,
                                  @RequestParam String unit,
                                  @RequestParam Double price,
                                  @RequestParam String description,
                                  Model model) {

      JpaProduct product = new JpaProduct(product_name, unit, price, description);
//      Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//      product.setCreated_at(currentTime);
      service.add(product);

      return "redirect:/product";
   }

   @GetMapping("/product/{id}")
   public String productInfo(@PathVariable(value = "id") long id, Model model) {
      if (service.getById(id) == null) {
         return "redirect:/product";
      }

      JpaProduct product = (JpaProduct) service.getById(id);
      model.addAttribute("product", product);

      return "product-info";
   }

   @GetMapping("/product/{id}/edit")
   public String productEdit(@PathVariable(value = "id") long id, Model model) {
      if (service.getById(id) == null) {
         return "redirect:/product";
      }

      JpaProduct product = (JpaProduct) service.getById(id);
      model.addAttribute("product", product);

      return "product-edit";
   }

   @PostMapping("/product/{id}/edit")
   public String productUpdate(@PathVariable(value = "id") long id,
                               @RequestParam String product_name,
                               @RequestParam String unit,
                               @RequestParam Double price,
                               @RequestParam String description,
                               Model model) {

      JpaProduct product = (JpaProduct) service.getById(id);

      product.setProduct_name(product_name);
      product.setUnit(unit);
      product.setPrice(price);
      product.setDescription(description);

      model.addAttribute("product", product);

      return "redirect:/product{id}";
   }

   @PostMapping("/product/{id}/remove")
   public String productDelete(@PathVariable(value = "id") long id,
                               Model model) {

      JpaProduct product = (JpaProduct) service.getById(id);
      product.setProduct_name(product.getProduct_name());
      service.deleteById(product.getId());

      return "redirect:/product";
   }
}
