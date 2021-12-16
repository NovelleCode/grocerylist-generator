package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
import se.iths.grocerylistgenerator.model.Ingredient;
import se.iths.grocerylistgenerator.model.Person;
import se.iths.grocerylistgenerator.model.Recipe;
import se.iths.grocerylistgenerator.model.Store;
import se.iths.grocerylistgenerator.repository.PersonRepository;

import java.util.List;

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
        return personMapper.mapp(personRepository.save(personMapper.mapp(addPersonDto)));
    }

    public List<PersonDto> findAllPersons() {
        return personMapper.mapp(personRepository.findAll());
    }

    public PersonDto findPersonById(Long id) {
        return personMapper.mapp(findById(id));
    }

    private Person findById (Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person with id: " + id + " not found"));
    }

    public PersonDto addRecipeIngredientsToGroceryList(Long personId, Long recipeId) {
        Person person = findById(personId);
        Recipe recipe = recipeService.findById(recipeId);
        recipe.getIngredients().forEach(person::addIngredientToGroceryList);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto addIngredientToGroceryList(Long personId, Long ingredientId) {
        Person person = findById(personId);
        Ingredient ingredient = ingredientService.findById(ingredientId);
        person.addIngredientToGroceryList(ingredient);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto addFavouriteStore(Long personId, Long storeId) {
        Person person = findById(personId);
        Store store = storeService.findById(storeId);
        person.setFavouriteStore(store);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto addRecipeToRecipeList(Long personId, Long recipeId) {
        Person person = findById(personId);
        Recipe recipe = recipeService.findById(recipeId);
        person.addRecipeToRecipeList(recipe);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto removeIngredientFromGroceryList(Long personId, Long ingredientId) {
        Person person = findById(personId);
        Ingredient ingredient = ingredientService.findById(ingredientId);
        person.removeIngredientFromGroceryList(ingredient);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto removeRecipeFromRecipeList(Long personId, Long recipeId) {
        Person person = findById(personId);
        Recipe recipe = recipeService.findById(recipeId);
        person.removeRecipeFromRecipeList(recipe);
        return personMapper.mapp(personRepository.save(person));
    }
}
