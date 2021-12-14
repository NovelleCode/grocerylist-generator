package se.iths.grocerylistgenerator.dto;

import se.iths.grocerylistgenerator.model.Category;

public class IngredientDto {

    private Long id;
    private String name;
    private Category category;

    public IngredientDto(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public IngredientDto() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
