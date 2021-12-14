package se.iths.grocerylistgenerator.mapper;

import se.iths.grocerylistgenerator.dto.RecipeDto;
import se.iths.grocerylistgenerator.model.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecipeMapper {

    public RecipeMapper() {
    }

    public Recipe mapp(RecipeDto recipeDto) {
        return new Recipe(recipeDto.getName(), recipeDto.getIngredients());
    }

    public RecipeDto mapp(Recipe recipe) {
        return new RecipeDto(recipe.getId(), recipe.getName(), recipe.getIngredients());
    }

    public List<RecipeDto> mapp(List<Recipe> recipes) {
        return recipes
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

    public Optional<RecipeDto> mapp(Optional<Recipe> optionalRecipe) {
        if (optionalRecipe.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalRecipe.get()));
    }
}
