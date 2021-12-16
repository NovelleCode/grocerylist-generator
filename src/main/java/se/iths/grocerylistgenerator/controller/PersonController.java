package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody AddPersonDto addPersonDto){
        PersonDto createdPerson = personService.createPerson(addPersonDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersons(){
        List<PersonDto> allPersons = personService.findAllPersons();
        return new ResponseEntity<>(allPersons, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Long id){
        PersonDto foundPerson = personService.findPersonById(id);
        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }

    @PostMapping("{personId}/grocerylist/recipes/{recipeId}")
    public ResponseEntity<PersonDto> addRecipeIngredientsToGroceryList(@PathVariable Long personId, @PathVariable Long recipeId) {
        PersonDto person = personService.addRecipeIngredientsToGroceryList(personId, recipeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("{personId}/grocerylist/ingredients/{ingredientId}")
    public ResponseEntity<PersonDto> addIngredientToGroceryList(@PathVariable Long personId, @PathVariable Long ingredientId) {
        PersonDto person = personService.addIngredientToGroceryList(personId, ingredientId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("{personId}/recipes/{recipeId}")
    public ResponseEntity<PersonDto> addRecipeToRecipeList(@PathVariable Long personId, @PathVariable Long recipeId) {
        PersonDto person = personService.addRecipeToRecipeList(personId, recipeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("{personId}/stores/{storeId}")
    public ResponseEntity<PersonDto> addFavouriteStore(@PathVariable Long personId, @PathVariable Long storeId) {
        PersonDto person = personService.addFavouriteStore(personId, storeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("{personId}/grocerylist/ingredients/{ingredientId}")
    public ResponseEntity<PersonDto> removeIngredientFromGroceryList(@PathVariable Long personId, @PathVariable Long ingredientId) {
        PersonDto person = personService.removeIngredientFromGroceryList(personId, ingredientId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("{personId}/recipes/{recipeId}")
    public ResponseEntity<PersonDto> removeRecipeFromRecipeList(@PathVariable Long personId, @PathVariable Long recipeId) {
        PersonDto person = personService.removeRecipeFromRecipeList(personId, recipeId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
