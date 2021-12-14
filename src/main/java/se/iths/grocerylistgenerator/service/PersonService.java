package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Person;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.model.Store;
import se.iths.grocerylistgenerator.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final StoreService storeService;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, RecipeService recipeService, IngredientService ingredientService, StoreService storeService, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.storeService = storeService;
        this.personMapper = personMapper;
    }

    public PersonDto createPerson(AddPersonDto addPersonDto) {
        // TODO: Felhantering
        return personMapper.mapp(personRepository.save(personMapper.mapp(addPersonDto)));
    }

    public List<PersonDto> findAllPersons() {
        return personMapper.mapp(personRepository.findAll());
    }

    public Optional<Person> findPersonById(Long id) {
        // TODO: Felhantering
        return personRepository.findById(id);
    }

    public Person addRecipeIngredientsToGroceryList(Long personId, Long recipeId) {
        Person person = findPersonById(personId).get();
        Optional<Recipe> recipe = recipeService.findRecipeById(recipeId);
        recipe.get().getIngredients().forEach(person::addIngredientToGroceryList);
        personRepository.save(person);
        return person;
    }

    public Person addIngredientToGroceryList(Long personId, Long ingredientId) {
        Person person = findPersonById(personId).get();
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
        person.addIngredientToGroceryList(ingredient);
        personRepository.save(person);
        return person;
    }

    public Person addFavouriteStore(Long personId, Long storeId) {
        Person person = findPersonById(personId).get();
        Store store = storeService.findStoreById(storeId).get();
        person.setFavouriteStore(store);
        personRepository.save(person);
        return person;
    }

    public Person addRecipeToRecipeList(Long personId, Long recipeId) {
        Person person = findPersonById(personId).get();
        Recipe recipe = recipeService.findRecipeById(recipeId).get();
        person.addRecipeToRecipeList(recipe);
        personRepository.save(person);
        return person;
    }

    public Person removeIngredientFromGroceryList(Long personId, Long ingredientId) {
        Person person = findPersonById(personId).get();
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
        person.removeIngredientFromGroceryList(ingredient);
        personRepository.save(person);
        return person;
    }

    public Person removeRecipeFromRecipeList(Long personId, Long recipeId) {
        Person person = findPersonById(personId).get();
        Recipe recipe = recipeService.findRecipeById(recipeId).get();
        person.removeRecipeFromRecipeList(recipe);
        personRepository.save(person);
        return person;
    }
}
