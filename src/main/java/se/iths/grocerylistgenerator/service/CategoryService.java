package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.CategoryDto;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
import se.iths.grocerylistgenerator.mapper.CategoryMapper;
import se.iths.grocerylistgenerator.model.Category;
import se.iths.grocerylistgenerator.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        isValidCategoryDto(categoryDto);
        checkCategoryNotInDatabase(categoryDto);
        return categoryMapper.mapp(categoryRepository.save(categoryMapper.mapp(categoryDto)));
    }

    private void isValidCategoryDto(CategoryDto categoryDto) {
        if (categoryDto.getName() == null || categoryDto.getName().isEmpty()) {
            throw new BadRequestException("Invalid input, you must enter a name for the category!");
        }
    }

    private void checkCategoryNotInDatabase(CategoryDto categoryDto) {
        Optional<Category> category = findCategoryByName(categoryDto.getName());
        if (category.isPresent()) {
            throw new BadRequestException("The category already exists in the database! Id: "
                    + category.get().getId() + ", Category: " + category.get().getName() );
        }
    }

    private Optional<Category> findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public List<CategoryDto> getAllCategories() {
        return categoryMapper.mapp(categoryRepository.findAll());
    }

    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.mapp(categoryRepository.findById(id)).orElseThrow(() -> new EntityNotFoundException("Category with id: " + id + " not found"));
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
