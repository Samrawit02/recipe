package com.samrit.controller;

import com.samrit.domain.Category;
import com.samrit.domain.UnitOfMeasure;
import com.samrit.repositories.CategoryRepository;
import com.samrit.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexpage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional= unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Category id "+ categoryOptional.get().getId());
        System.out.println("uom id" +unitOfMeasureOptional.get().getId());


        System.out.println("hi 5 to you");
        return "index";
    }
}
