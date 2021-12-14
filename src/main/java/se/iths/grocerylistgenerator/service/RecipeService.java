package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.repository.IngredientRepository;
import se.iths.grocerylistgenerator.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private final IngredientService ingredientService;

    public RecipeService(RecipeRepository recipeRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
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
        return recipeRepository.findByIngredientsAndId(ingredientIds);
    }


/*    public Iterable<Recipe> findRecipeByIngredient(List<Long> ingredientIds){
        //vi får in en lista av ingrediensid

        // recipes tabel
        // 1. pasta bolognese - [pasta, tomat, meatballs]
        // 2. scrambled eggs - [eggs]
        // 3. omelette - [eggs]

        *//*
        vad vi har hemma:
        5. egg

        Vi vill kolla vilka recept har ägg i sig

         *//*
        List<Recipe> recipes = (List<Recipe>) findAllRecipes();

        *//*
        Loopa igenom varje recept som finns i databasen
        Kolla/filtera inuti varje recept: har det här receptet samma ingrediensId som jag har skickat?
        om ja -> behålla recept
        om nej -> släng recept
        alla recept som vi behåller -> spara i lista
         *//*
*//*        var hello = recipes.stream().peek
                (recipe -> recipe.getIngredients().stream().filter(ingredient -> ingredient.getId() == 5))
                .toList();

        System.out.println(hello);

        Ingredient ingredient =  ingredientService.getIngredientById(ingredientIds.get(0));*//*
    }*/
}
