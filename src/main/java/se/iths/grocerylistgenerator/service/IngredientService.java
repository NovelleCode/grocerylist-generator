package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        // TODO: add ingredient.getCategory == null down here once relations are fixed
        if (ingredient.getName().isEmpty() || ingredient.getQuantity().isEmpty())
            throw new RuntimeException("Incomplete ingredient");
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient with id " + id + "not found"));
    }
}
