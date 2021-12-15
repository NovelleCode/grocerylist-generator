package se.iths.grocerylistgenerator.dto;

import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.model.Store;

import java.util.Set;

public class PersonDto {

    private Long id;
    private String username;
    private Set<IngredientDto> groceries;
    private Set<Recipe> recipes;
    private Store favouriteStore;

    public PersonDto(Long id, String username, Set<IngredientDto> groceries, Set<Recipe> recipes, Store favouriteStore) {
        this.id = id;
        this.username = username;
        this.groceries = groceries;
        this.recipes = recipes;
        this.favouriteStore = favouriteStore;
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Store getFavouriteStore() {
        return favouriteStore;
    }

    public void setFavouriteStore(Store favouriteStore) {
        this.favouriteStore = favouriteStore;
    }
}
