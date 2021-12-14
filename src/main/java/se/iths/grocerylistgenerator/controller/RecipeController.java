package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Recipe;
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
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Recipe>> findAllRecipes(){
        Iterable<Recipe> allRecipes = recipeService.findAllRecipes();
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Recipe>> findRecipeById(@PathVariable Long id){
        Optional<Recipe> foundRecipe = recipeService.findRecipeById(id);
        return new ResponseEntity<>(foundRecipe, HttpStatus.OK);
    }

    @GetMapping("ingredients")
    public ResponseEntity<Iterable<Recipe>> findRecipesByIngredients(@RequestParam List<Long> ingredientIds){
        //Skickar in lista med ingrediens id. Vi vill få tillbaka lista med recept som
        // matchar/inehåller en viss ingrediens.
        Iterable<Recipe> foundRecipe=  recipeService.findRecipeByIngredient(ingredientIds);
        return new ResponseEntity<>(foundRecipe, HttpStatus.OK);
    }

}
