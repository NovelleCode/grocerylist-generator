package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
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
        isValidAddPersonDto(addPersonDto);
        checkUsernameNotTaken(addPersonDto);
        return personMapper.mapp(personRepository.save(personMapper.mapp(addPersonDto)));
    }

    private void isValidAddPersonDto(AddPersonDto addPersonDto) {
        if(addPersonDto.getUsername() == null || addPersonDto.getUsername().isEmpty()
                || addPersonDto.getPassword() == null || addPersonDto.getPassword().isEmpty()) {
            throw new BadRequestException("Invalid input in request body");
        }
    }

    private void checkUsernameNotTaken(AddPersonDto addPersonDto) {
        if(findByUsername(addPersonDto.getUsername()).isPresent()){
            throw new BadRequestException("Username already taken!");
        }
    }

    private Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
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
        if(person.getGroceries().contains(ingredient)){
            person.removeIngredientFromGroceryList(ingredient);
            return personMapper.mapp(personRepository.save(person));
        }
        throw new EntityNotFoundException("Ingredient with id: " + ingredientId + " not found and therefore not deleted.");
    }

    public PersonDto removeRecipeFromRecipeList(Long personId, Long recipeId) {
        Person person = findById(personId);
        Recipe recipe = recipeService.findById(recipeId);
        if(person.getRecipes().contains(recipe)){
            person.removeRecipeFromRecipeList(recipe);
            return personMapper.mapp(personRepository.save(person));
        }
        throw new EntityNotFoundException("Recipe with id: " + recipeId + " not found and therefore not deleted.");
    }
}
