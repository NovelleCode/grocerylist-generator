package se.iths.grocerylistgenerator.dto;

import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.model.Store;

import java.util.Set;

public class PersonDto {

    private Long id;
    private String username;
    private Set<IngredientDto> groceries;
    private Set<RecipeDto> recipes;
    private StoreDto favouriteStore;

    public PersonDto(Long id, String username, Set<IngredientDto> groceries, Set<RecipeDto> recipes, StoreDto favouriteStore) {
        this.id = id;
        this.username = username;
        this.groceries = groceries;
        this.recipes = recipes;
        this.favouriteStore = favouriteStore;
    }

    public void addIngredientToGroceryList(IngredientDto ingredientDto) {
        groceries.add(ingredientDto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<IngredientDto> getGroceries() {
        return groceries;
    }

    public void setGroceries(Set<IngredientDto> groceries) {
        this.groceries = groceries;
    }

    public Set<RecipeDto> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeDto> recipes) {
        this.recipes = recipes;
    }

    public StoreDto getFavouriteStore() {
        return favouriteStore;
    }

    public void setFavouriteStore(StoreDto favouriteStore) {
        this.favouriteStore = favouriteStore;
    }
}
