package se.iths.grocerylistgenerator.dto;

import se.iths.grocerylistgenerator.model.Category;

public class IngredientDto {

    private Long id;
    private String name;
    private CategoryDto categoryDto;

    public IngredientDto(Long id, String name, CategoryDto categoryDto) {
        this.id = id;
        this.name = name;
        this.categoryDto = categoryDto;
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

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
