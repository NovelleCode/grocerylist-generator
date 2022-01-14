package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddIngredientDto;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.CategoryDto;
import se.iths.grocerylistgenerator.dto.IngredientDto;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
import se.iths.grocerylistgenerator.mapper.IngredientMapper;
import se.iths.grocerylistgenerator.entity.Ingredient;
import se.iths.grocerylistgenerator.entity.Category;
import se.iths.grocerylistgenerator.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;

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
        isValidIngredientDto(addIngredientDto);
        checkIngredientNotInDatabase(addIngredientDto);
        return ingredientMapper.mapp(ingredientRepository.save(ingredientMapper.mapp(addIngredientDto)));
    }

    private void isValidIngredientDto(AddIngredientDto ingredientDto) {
        if(ingredientDto.getName() == null || ingredientDto.getName().isEmpty()) {
            throw new BadRequestException("Invalid input, you must enter a name for the ingredient!");
        }
    }

    private void checkIngredientNotInDatabase(AddIngredientDto ingredientDto) {
        Optional<Ingredient> ingredient = findIngredientByName(ingredientDto.getName());
        if (ingredient.isPresent()) {
            throw new BadRequestException("The ingredient already exists in the database! Id: "
                    + ingredient.get().getId() + ", Name: " + ingredient.get().getName() );
        }
    }

    private Optional<Ingredient> findIngredientByName(String name) {
        return ingredientRepository.findByName(name);
    }

    public List<IngredientDto> getAllIngredients() {
        return ingredientMapper.mapp(ingredientRepository.findAll());
    }

    public IngredientDto getIngredientById(Long id) {
        return ingredientMapper.mapp(findById(id));
    }

    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ingredient with id " + id + "not found"));
    }

    public IngredientDto addCategoryToIngredient(Long ingredientId, Long categoryId) {
        Ingredient ingredient = findById(ingredientId);
        Category category = categoryService.findById(categoryId).get();
        ingredient.setCategory(category);
        return ingredientMapper.mapp(ingredientRepository.save(ingredient));
    }
}
