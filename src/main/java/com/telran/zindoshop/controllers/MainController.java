package com.telran.zindoshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

   @GetMapping("/")
   public String home(Model model) {
      model.addAttribute("title", "Главная страница");
      return "index";
   }

   @GetMapping("/registration")
   public String registration(Model model) {
      model.addAttribute("title", "Регистрация");
      return "registration";
   }

}
