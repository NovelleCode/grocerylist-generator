package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Person;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        // TODO: Felhantering
        return personRepository.save(person);
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonById(Long id) {
        // TODO: Felhantering
        return personRepository.findById(id);
    }

    public Person addRecipeIngredientsToGroceryList(Long personId, Long recipeId) {
        Person person = findPersonById(personId).get();
        Optional<Recipe> recipe = recipeService.findRecipeById(recipeId);
        recipe.get().getIngredients().forEach(person::addIngredientGroceries);
        personRepository.save(person);
        return person;
    }

    public Person addIngredientToGroceryList(Long personId, Long ingredientId) {
        Person person = findPersonById(personId).get();
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
        person.addIngredientGroceries(ingredient);
        personRepository.save(person);
        return person;
    }
}
