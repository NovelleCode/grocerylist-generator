package se.iths.grocerylistgenerator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.grocerylistgenerator.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
