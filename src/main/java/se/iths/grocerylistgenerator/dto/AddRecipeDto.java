package se.iths.grocerylistgenerator.dto;

public class AddRecipeDto {
    private String name;

    public AddRecipeDto(String name) {
        this.name = name;
    }

    public AddRecipeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
