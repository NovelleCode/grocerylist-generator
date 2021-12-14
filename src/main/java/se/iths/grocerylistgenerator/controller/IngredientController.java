package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.IngredientDto;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.service.IngredientService;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody IngredientDto ingredientDto) {
        return new ResponseEntity<>(ingredientService.createIngredient(ingredientDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients() {
        return new ResponseEntity<>(ingredientService.getAllIngredients(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable Long id) {
        return new ResponseEntity<>(ingredientService.getIngredientById(id), HttpStatus.OK);
    }
}
