package com.telran.zindoshop.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

   @GetMapping("/")
   public String adminPanel(Model model) {
      model.addAttribute("title", "Admin panel");
      return "admin-panel";
   }

   @GetMapping("/test")
   public String products(Model model) {
      model.addAttribute("title", "List of all products");
      return "admin-panel";
   }

}
