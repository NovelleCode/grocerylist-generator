package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.RecipeDto;
import se.iths.grocerylistgenerator.mapper.RecipeMapper;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<RecipeDto> findRecipeById(Long id){
        return recipeMapper.mapp(findById(id));
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public List<RecipeDto> findAllRecipes(){
        return recipeMapper.mapp(recipeRepository.findAll());
    }

    public List<RecipeDto> findRecipeByIngredient(List<Long> ingredientIds){
        return recipeMapper.mapp(recipeRepository.findRecipesThatMatchIngredientIds(ingredientIds));
    }
}
