package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddRecipeDto;
import se.iths.grocerylistgenerator.dto.RecipeDto;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
import se.iths.grocerylistgenerator.mapper.RecipeMapper;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, IngredientService ingredientService, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
        this.recipeMapper = recipeMapper;
    }

    public RecipeDto createRecipe(AddRecipeDto recipeDto) {
        isValidRecipeDto(recipeDto);
        checkRecipeNotInDatabase(recipeDto);
        return recipeMapper.mapp(recipeRepository.save(recipeMapper.mapp(recipeDto)));
    }

    private void isValidRecipeDto(AddRecipeDto recipeDto) {
        if (recipeDto.getName() == null || recipeDto.getName().isEmpty()) {
            throw new BadRequestException("Invalid input, you must enter a name for the recipe!");
        }
    }

    private void checkRecipeNotInDatabase(AddRecipeDto recipeDto) {
        Optional<Recipe> recipe = findRecipeByName(recipeDto.getName());
        if (recipe.isPresent()) {
            throw new BadRequestException("The recipe already exists in the database! Id: "
                    + recipe.get().getId() + ", Name: " + recipe.get().getName());
        }
    }

    private Optional<Recipe> findRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    public RecipeDto findRecipeById(Long id) {
        return recipeMapper.mapp(findById(id));
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + id + " not found"));
    }

    public List<RecipeDto> findAllRecipes() {
        return recipeMapper.mapp(recipeRepository.findAll());
    }

    public List<RecipeDto> findRecipeByIngredient(List<Long> ingredientIds) {
        return recipeMapper.mapp(recipeRepository.findRecipesThatMatchIngredientIds(ingredientIds));
    }

    public RecipeDto addIngredientsToRecipe(Long recipeId, List<Long> ingredientIds) {
        Recipe recipe = findById(recipeId);
        Set<Ingredient> ingredients = ingredientIds.stream().map(ingredientService::findById).collect(Collectors.toSet());
        recipe.setIngredients(ingredients);
        return  recipeMapper.mapp(recipeRepository.save(recipe));
    }
}
