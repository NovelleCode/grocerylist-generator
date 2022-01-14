package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.service.PersonService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@PreAuthorize("hasRole('ROLE_USER')")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> findAllPersons() {
        List<PersonDto> allPersons = personService.findAllPersons();
        return new ResponseEntity<>(allPersons, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<PersonDto> findPersonByUsername(Principal principal) {
        PersonDto foundPerson = personService.findPersonByUsername(principal.getName());
        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }

    @PostMapping("/grocerylist/recipes/{recipeId}")
    public ResponseEntity<PersonDto> addRecipeIngredientsToGroceryList(Principal principal, @PathVariable Long recipeId) {
        PersonDto person = personService.addRecipeIngredientsToGroceryList(principal.getName(), recipeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("grocerylist/ingredients/{ingredientId}")
    public ResponseEntity<PersonDto> addIngredientToGroceryList(Principal principal, @PathVariable Long ingredientId) {
        PersonDto person = personService.addIngredientToGroceryList(principal.getName(), ingredientId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/recipes/{recipeId}")
    public ResponseEntity<PersonDto> addRecipeToRecipeList(Principal principal, @PathVariable Long recipeId) {
        PersonDto person = personService.addRecipeToRecipeList(principal.getName(), recipeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/stores/{storeId}")
    public ResponseEntity<PersonDto> addFavouriteStore(Principal principal, @PathVariable Long storeId) {
        PersonDto person = personService.addFavouriteStore(principal.getName(), storeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/grocerylist/ingredients/{ingredientId}")
    public ResponseEntity<PersonDto> removeIngredientFromGroceryList(Principal principal, @PathVariable Long ingredientId) {
        PersonDto person = personService.removeIngredientFromGroceryList(principal.getName(), ingredientId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public ResponseEntity<PersonDto> removeRecipeFromRecipeList(Principal principal, @PathVariable Long recipeId) {
        PersonDto person = personService.removeRecipeFromRecipeList(principal.getName(), recipeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
