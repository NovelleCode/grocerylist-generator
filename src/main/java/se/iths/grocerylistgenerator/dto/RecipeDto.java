package se.iths.grocerylistgenerator.dto;

import java.util.Set;

public class RecipeDto {

    private Long id;
    private String name;
    private Set<IngredientDto> ingredients;

    public RecipeDto(Long id, String name, Set<IngredientDto> ingredients) {
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

    public Set<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
