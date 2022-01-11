package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.AddRecipeDto;
import se.iths.grocerylistgenerator.dto.RecipeDto;
import se.iths.grocerylistgenerator.service.RecipeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping()
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody AddRecipeDto recipeDto){
        RecipeDto createdRecipe = recipeService.createRecipe(recipeDto);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @PostMapping("{recipeId}/ingredients/{ingredientIds}")
    public ResponseEntity<RecipeDto> addIngredientsToRecipe(@PathVariable Long recipeId, @PathVariable List<Long> ingredientIds) {
        RecipeDto recipe = recipeService.addIngredientsToRecipe(recipeId, ingredientIds);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<List<RecipeDto>> findAllRecipes(){
        List<RecipeDto> allRecipes = recipeService.findAllRecipes();
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RecipeDto> findRecipeById(@PathVariable Long id){
        RecipeDto foundRecipe = recipeService.findRecipeById(id);
        return new ResponseEntity<>(foundRecipe, HttpStatus.OK);
    }

    @GetMapping("ingredients")
    public ResponseEntity<Set<RecipeDto>> findRecipesByIngredients(@RequestParam List<Long> ingredientIds){
        Set<RecipeDto> foundRecipe = recipeService.findRecipeByIngredient(ingredientIds);
        return new ResponseEntity<>(foundRecipe, HttpStatus.OK);
    }

}
