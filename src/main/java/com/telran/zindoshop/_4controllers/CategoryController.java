package com.telran.zindoshop._4controllers;

import com.telran.zindoshop._1domain.interfaces.Category;
import com.telran.zindoshop._1domain.jpa.JpaCategory;
import com.telran.zindoshop._3service.jpa.JpaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

//   @Autowired
//   private CategoryService service;

   @Autowired
   private JpaCategoryService service;

   @GetMapping("")
   public String getAll(Model model) {
      List<Category> categories = service.getAll();
      model.addAttribute("categories", categories);
      return "categories/all";
   }
}
