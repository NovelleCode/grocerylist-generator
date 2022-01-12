package se.iths.grocerylistgenerator.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.entity.Ingredient;
import se.iths.grocerylistgenerator.entity.Person;
import se.iths.grocerylistgenerator.entity.Recipe;
import se.iths.grocerylistgenerator.entity.Store;
import se.iths.grocerylistgenerator.exception.EntityNotFoundException;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
import se.iths.grocerylistgenerator.repository.PersonRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> optionalPerson = personRepository.findByUsername(username);
        if (optionalPerson.isEmpty()) {
            throw new UsernameNotFoundException("User not found in the database");
        }
        Person person = optionalPerson.get();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(person.getRole().getRoleName());

        return new User(username, person.getPassword(), Collections.singleton(authority));
    }

    public List<PersonDto> findAllPersons() {
        return personMapper.mapp(personRepository.findAll());
    }

    public PersonDto findPersonByUsername(String username) {
        return personMapper.mapp(findByUsername(username));
    }

    private Person findByUsername(String username) {
        return personRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Username not found, you have to sign up"));
    }

    public PersonDto addRecipeIngredientsToGroceryList(String username, Long recipeId) {
        Person person = findByUsername(username);
        Recipe recipe = recipeService.findById(recipeId);
        recipe.getIngredients().forEach(person::addIngredientToGroceryList);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto addIngredientToGroceryList(String username, Long ingredientId) {
        Person person = findByUsername(username);
        Ingredient ingredient = ingredientService.findById(ingredientId);
        person.addIngredientToGroceryList(ingredient);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto addFavouriteStore(String username, Long storeId) {
        Person person = findByUsername(username);
        Store store = storeService.findById(storeId);
        person.setFavouriteStore(store);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto addRecipeToRecipeList(String username, Long recipeId) {
        Person person = findByUsername(username);
        Recipe recipe = recipeService.findById(recipeId);
        person.addRecipeToRecipeList(recipe);
        return personMapper.mapp(personRepository.save(person));
    }

    public PersonDto removeIngredientFromGroceryList(String username, Long ingredientId) {
        Person person = findByUsername(username);
        Ingredient ingredient = ingredientService.findById(ingredientId);
        if (person.getGroceries().contains(ingredient)) {
            person.removeIngredientFromGroceryList(ingredient);
            return personMapper.mapp(personRepository.save(person));
        }
        throw new EntityNotFoundException("Ingredient with id: " + ingredientId + " not found and therefore not deleted.");
    }

    public PersonDto removeRecipeFromRecipeList(String username, Long recipeId) {
        Person person = findByUsername(username);
        Recipe recipe = recipeService.findById(recipeId);
        if (person.getRecipes().contains(recipe)) {
            person.removeRecipeFromRecipeList(recipe);
            return personMapper.mapp(personRepository.save(person));
        }
        throw new EntityNotFoundException("Recipe with id: " + recipeId + " not found and therefore not deleted.");
    }
}
