package se.iths.grocerylistgenerator.dto;

public class IngredientDto {

    private Long id;
    private String name;
    private CategoryDto category;

    public IngredientDto(Long id, String name, CategoryDto categoryDto) {
        this.id = id;
        this.name = name;
        this.category = categoryDto;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
