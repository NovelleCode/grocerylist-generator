package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddIngredientDto;
import se.iths.grocerylistgenerator.dto.IngredientDto;
import se.iths.grocerylistgenerator.mapper.IngredientMapper;
import se.iths.grocerylistgenerator.model.Category;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final CategoryService categoryService;
    private final IngredientMapper ingredientMapper;

    public IngredientService(IngredientRepository ingredientRepository, CategoryService categoryService, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.categoryService = categoryService;
        this.ingredientMapper = ingredientMapper;
    }

    public IngredientDto createIngredient(AddIngredientDto addIngredientDto) {
        if (addIngredientDto.getName().isEmpty())
            throw new RuntimeException("Incomplete ingredient");
        return ingredientMapper.mapp(ingredientRepository.save(ingredientMapper.mapp(addIngredientDto)));
    }

    public List<IngredientDto> getAllIngredients() {
        return ingredientMapper.mapp(ingredientRepository.findAll());
    }

    public IngredientDto getIngredientById(Long id) {
        return ingredientMapper.mapp(findById(id));
    }

    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient with id " + id + "not found"));
    }

    public IngredientDto addCategoryToIngredient(Long ingredientId, Long categoryId) {
        Ingredient ingredient = findById(ingredientId);
        Category category = categoryService.findById(categoryId).get();
        ingredient.setCategory(category);
        return ingredientMapper.mapp(ingredientRepository.save(ingredient));
    }
}
