package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
