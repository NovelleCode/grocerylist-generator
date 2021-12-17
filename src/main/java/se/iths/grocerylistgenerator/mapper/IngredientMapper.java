package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.IngredientDto;
import se.iths.grocerylistgenerator.entity.Ingredient;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IngredientMapper {

    CategoryMapper categoryMapper;

    public IngredientMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Ingredient mapp(IngredientDto ingredientDto) {
        return new Ingredient(ingredientDto.getName(), categoryMapper.mapp(ingredientDto.getCategoryDto()));
    }

    public IngredientDto mapp(Ingredient ingredient) {
        return new IngredientDto(ingredient.getId(), ingredient.getName(), categoryMapper.mapp(ingredient.getCategory()));
    }

    public List<IngredientDto> mapp(List<Ingredient> ingredients) {
        return ingredients
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

    public Set<IngredientDto> mapp(Set<Ingredient> ingredients) {
        return ingredients
                .stream()
                .map(this::mapp)
                .collect(Collectors.toSet());
    }

    public Set<Ingredient> mappToIngredientSet(Set<IngredientDto> ingredients) {
        return ingredients
                .stream()
                .map(this::mapp)
                .collect(Collectors.toSet());
    }

    public Optional<IngredientDto> mapp(Optional<Ingredient> optionalIngredient) {
        if (optionalIngredient.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalIngredient.get()));
    }
}
