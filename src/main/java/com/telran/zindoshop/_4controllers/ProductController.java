package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.interfaces.Category;
import com.telran.zindoshop._1domain.interfaces.Product;
import com.telran.zindoshop._1domain.interfaces.Supplier;
import com.telran.zindoshop._1domain.jpa.JpaProduct;
import com.telran.zindoshop._2repo.ProductRepository;
import com.telran.zindoshop._3service.jpa.JpaCategoryService;
import com.telran.zindoshop._3service.jpa.JpaProductService;
import com.telran.zindoshop._3service.jpa.JpaSupplierService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

   @Autowired
   private JpaProductService service;

   @Autowired
   private JpaCategoryService categoryService;

   @Autowired
   private JpaSupplierService supplierService;

   @Autowired
   private ProductRepository repository;


   @GetMapping("")
   public String getAll(Model model) {
      Iterable<Product> products = service.getAll();
      model.addAttribute("products", products);

      return "/products/all";
   }

   /**
    *
    * @param model
    * @return
    */
   @GetMapping("/add")
   public String addProductForm(Model model) {
      Iterable<Category> categories = categoryService.getAll();
      Iterable<Supplier> suppliers = supplierService.getAll();

      model.addAttribute("categories", categories);
      model.addAttribute("suppliers", suppliers);

      return "/products/add";
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
   @PostMapping("/add")
   public String addProductAction(@RequestParam String product_name,
                                  @RequestParam String unit,
                                  @RequestParam @Valid Double price,
                                  @RequestParam String description,
                                  @RequestParam long category_id,
                                  @RequestParam long supplier_id,
                                  @RequestParam(name = "available", required = false, defaultValue = "false") boolean available,
                                  Model model) {

//      JpaProduct product = new JpaProduct(product_name, unit, price, description);
      JpaProduct product = new JpaProduct(product_name, unit, price, supplier_id, category_id, description, available);

      service.add(product);

      return "redirect:/product";
   }

   @GetMapping("/{id}")
   public String productInfo(@PathVariable(value = "id") long id, Model model) {
      if (service.getById(id) == null) {
         return "redirect:/product";
      }

      JpaProduct product = (JpaProduct) service.getById(id);
      model.addAttribute("product", product);

      return "/products/info";
   }

   @GetMapping("/{id}/edit")
   public String productEdit(@PathVariable(value = "id") long id, Model model) {
      if (service.getById(id) == null) {
         return "redirect:/product";
      }

      JpaProduct product = (JpaProduct) service.getById(id);
      model.addAttribute("product", product);

      return "/products/edit";
   }

   @PostMapping("/{id}/edit")
   public String productUpdate(@PathVariable(value = "id") long id,
                               @RequestParam String product_name,
                               @RequestParam String unit,
                               @RequestParam @Valid Double price,
                               @RequestParam String description,
                               Model model) {

      JpaProduct product = (JpaProduct) service.getById(id);
      JpaProduct product1 = repository.findById(id).orElseThrow();

      // todo: реализовать для service, а не repository
//      product.setProduct_name(product_name);
//      product.setUnit(unit);
//      product.setPrice(price);
//      product.setDescription(description);
//      product.setCategory_id(0L);
//      product.setSupplier_id(0L);
//      service.add(product);

      product1.setProduct_name(product_name);
      product1.setUnit(unit);
      product1.setPrice(price);
      product1.setDescription(description);
      repository.save(product1);

      model.addAttribute("product", product);

      return "redirect:/product";
   }

   @PostMapping("/{id}/remove")
   public String productDelete(@PathVariable(value = "id") long id,
                               Model model) {

      JpaProduct product = (JpaProduct) service.getById(id);
      product.setProduct_name(product.getProduct_name());
      service.deleteById(product.getId());

      return "redirect:/product";
   }
}
