package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.RecipeDto;
import se.iths.grocerylistgenerator.service.RecipeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @PostMapping()
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto){
        RecipeDto createdRecipe = recipeService.createRecipe(recipeDto);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
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
    public ResponseEntity<List<RecipeDto>> findRecipesByIngredients(@RequestParam List<Long> ingredientIds){
        List<RecipeDto> foundRecipe = recipeService.findRecipeByIngredient(ingredientIds);
        return new ResponseEntity<>(foundRecipe, HttpStatus.OK);
    }

}
