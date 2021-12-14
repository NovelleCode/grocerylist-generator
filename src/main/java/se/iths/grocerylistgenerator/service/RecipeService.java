package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public Recipe createRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> findRecipeById(Long id){
        return recipeRepository.findById(id);
    }

    public Iterable<Recipe> findAllRecipes(){
        return recipeRepository.findAll();
    }

    public List<Recipe> findRecipeByIngredient(List<Long> ingredientIds){
        return recipeRepository.findRecipesThatMatchIngredientIds(ingredientIds);
    }
}
