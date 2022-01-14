package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.AddIngredientDto;
import se.iths.grocerylistgenerator.dto.IngredientDto;
import se.iths.grocerylistgenerator.service.IngredientService;

import java.util.List;

@RestController()
@RequestMapping("/api/ingredients")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody AddIngredientDto addIngredientDto) {
        return new ResponseEntity<>(ingredientService.createIngredient(addIngredientDto), HttpStatus.CREATED);
    }

    @PostMapping("/{ingredientId}/category/{categoryId}")
    public ResponseEntity<IngredientDto> addCategoryToIngredient(@PathVariable Long ingredientId, @PathVariable Long categoryId) {
        return new ResponseEntity<>(ingredientService.addCategoryToIngredient(ingredientId, categoryId), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients() {
        return new ResponseEntity<>(ingredientService.getAllIngredients(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable Long id) {
        return new ResponseEntity<>(ingredientService.getIngredientById(id), HttpStatus.OK);
    }
}
