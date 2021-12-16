package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.RecipeDto;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
import se.iths.grocerylistgenerator.mapper.RecipeMapper;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public RecipeDto createRecipe(RecipeDto recipeDto){
        return recipeMapper.mapp(recipeRepository.save(recipeMapper.mapp(recipeDto)));
    }

    public RecipeDto findRecipeById(Long id){
        return recipeMapper.mapp(findById(id));
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + id + " not found"));
    }

    public List<RecipeDto> findAllRecipes(){
        return recipeMapper.mapp(recipeRepository.findAll());
    }

    public List<RecipeDto> findRecipeByIngredient(List<Long> ingredientIds){
        return recipeMapper.mapp(recipeRepository.findRecipesThatMatchIngredientIds(ingredientIds));
    }
}
