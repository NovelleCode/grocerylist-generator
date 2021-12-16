package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.IngredientDto;
import se.iths.grocerylistgenerator.mapper.IngredientMapper;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    public IngredientDto createIngredient(IngredientDto ingredientDto) {
        if (ingredientDto.getName().isEmpty() || ingredientDto.getCategory() == null)
            throw new RuntimeException("Incomplete ingredient");
        return ingredientMapper.mapp(ingredientRepository.save(ingredientMapper.mapp(ingredientDto)));
    }

    public List<IngredientDto> getAllIngredients() {
        return ingredientMapper.mapp(ingredientRepository.findAll());
    }

    public IngredientDto getIngredientById(Long id) {
        return ingredientMapper.mapp(findIngredientById(id));
    }

    public Ingredient findIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient with id " + id + "not found"));
    }
}
