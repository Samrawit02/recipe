package com.samrit.controller;

import com.samrit.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }



    @RequestMapping({"","/","/index"})
    public String getIndexpage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());



        System.out.println("hi 5 to you");
        return "index";
    }
}
