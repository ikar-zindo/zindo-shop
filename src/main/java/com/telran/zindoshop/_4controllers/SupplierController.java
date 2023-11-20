package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.interfaces.Supplier;
import com.telran.zindoshop._1domain.jpa.JpaSupplier;
import com.telran.zindoshop._3service.jpa.JpaSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

   @Autowired
   private JpaSupplierService service;

   @GetMapping("") // "" != "/"
//   @GetMapping("/supplier")
   public String getAll(Model model) {
      List<Supplier> suppliers = service.getAll();
      model.addAttribute("suppliers", suppliers);
      return "suppliers/all";
   }

   @GetMapping("/{id}")
//   @GetMapping("/supplier/{id}")
   public String supplierInfo(@PathVariable(value = "id") long id, Model model) {
      if (service.getById(id) == null) {
         return "redirect:/supplier/all";
      }

      JpaSupplier supplier = (JpaSupplier) service.getById(id);
      model.addAttribute("supplier", supplier);

      return "suppliers/info";
   }

   @GetMapping("/add")
   public String addSupplier(Model model) {
      return "suppliers/add";
   }

   @PostMapping("/add")
   public String addSupplierAction(@RequestParam String supplier_name,
                                   @RequestParam String contact_name,
                                   @RequestParam String address,
                                   @RequestParam String city,
                                   @RequestParam String postal_code,
                                   @RequestParam String country,
                                   @RequestParam String phone,
                                   Model model) {

      JpaSupplier supplier = new JpaSupplier(supplier_name, contact_name, address,
              city, postal_code, country, phone);
      service.add(supplier);

      return "redirect:/supplier";
   }


   @GetMapping("/{id}/edit")
   public String supplierEdit(@PathVariable(value = "id") long id, Model model) {
      if (service.getById(id) == null) {
         return "redirect:/supplier/all";
      }

      JpaSupplier supplier = (JpaSupplier) service.getById(id);
      model.addAttribute("supplier", supplier);

      return "suppliers/edit";
   }

   @PostMapping("/{id}/edit")
   public String supplierUpdate(@PathVariable(value = "id") long id,
                                @RequestParam String supplier_name,
                                @RequestParam String contact_name,
                                @RequestParam String address,
                                @RequestParam String city,
                                @RequestParam String postal_code,
                                @RequestParam String country,
                                @RequestParam String phone,
                                Model model) {

      JpaSupplier supplier = (JpaSupplier) service.getById(id);


      supplier.setSupplier_name(supplier_name);
      supplier.setContact_name(contact_name);
      supplier.setAddress(address);
      supplier.setCity(city);
      supplier.setPostal_code(postal_code);
      supplier.setCountry(country);
      supplier.setPhone(phone);

//      service.add(supplier);

      model.addAttribute("supplier", supplier);

      return "redirect:/supplier/{id}";
   }

   @PostMapping("/{id}/remove")
   public String productDelete(@PathVariable(value = "id") long id,
                               Model model) {

      JpaSupplier supplier = (JpaSupplier) service.getById(id);
      supplier.setSupplier_name(supplier.getName());
      service.deleteById(supplier.getId());

      return "redirect:/supplier";
   }
}
