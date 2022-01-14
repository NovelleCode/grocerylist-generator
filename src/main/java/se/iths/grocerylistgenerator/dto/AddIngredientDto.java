package se.iths.grocerylistgenerator.dto;

public class AddIngredientDto {
    private String name;

    public AddIngredientDto(String name) {
        this.name = name;
    }

    public AddIngredientDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
