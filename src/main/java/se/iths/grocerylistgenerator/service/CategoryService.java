package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.CategoryDto;
import se.iths.grocerylistgenerator.mapper.CategoryMapper;
import se.iths.grocerylistgenerator.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        if(categoryDto.getName().isEmpty()) {
            throw new RuntimeException("Incomplete category");
        }
        return categoryMapper.mapp(categoryRepository.save(categoryMapper.mapp(categoryDto)));
    }

    public List<CategoryDto> getAllCategories() {
        return categoryMapper.mapp(categoryRepository.findAll());
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.mapp(categoryRepository.findById(id)).orElseThrow(() -> new RuntimeException("Category with id " + id + "not found"));
    }
}
