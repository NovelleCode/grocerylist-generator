package se.iths.grocerylistgenerator.dto;

import se.iths.grocerylistgenerator.model.Ingredient;

import java.util.Set;

public class RecipeDto {

    private Long id;
    private String name;
    private Set<Ingredient> ingredients;

    public RecipeDto(Long id, String name, Set<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public RecipeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
