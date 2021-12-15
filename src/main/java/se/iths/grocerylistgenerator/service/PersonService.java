package se.iths.grocerylistgenerator.service;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.*;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
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

    public Optional<PersonDto> findPersonById(Long id) {
        // TODO: Felhantering
        return personMapper.mapp(personRepository.findById(id));
    }

    public PersonDto addRecipeIngredientsToGroceryList(Long personId, Long recipeId) {
        PersonDto personDto = findPersonById(personId).get();
        RecipeDto recipeDto = recipeService.findRecipeById(recipeId).get();
        recipeDto.getIngredients().forEach(personDto::addIngredientToGroceryList);
        return personMapper.mapp(personRepository.save(personMapper.mapp(personDto)));
    }

    public PersonDto addIngredientToGroceryList(Long personId, Long ingredientId) {
        PersonDto personDto = findPersonById(personId).get();
        IngredientDto ingredientDto = ingredientService.getIngredientById(ingredientId);
        personDto.addIngredientToGroceryList(ingredientDto);
        return personMapper.mapp(personRepository.save(personMapper.mapp(personDto)));
    }

    public PersonDto addFavouriteStore(Long personId, Long storeId) {
        PersonDto personDto = findPersonById(personId).get();
        StoreDto storeDto = storeService.findStoreById(storeId).get();
        personDto.setFavouriteStore(storeDto);
        return personMapper.mapp(personRepository.save(personMapper.mapp(personDto)));
    }

    public PersonDto addRecipeToRecipeList(Long personId, Long recipeId) {
        PersonDto personDto = findPersonById(personId).get();
        RecipeDto recipeDto = recipeService.findRecipeById(recipeId).get();
        personDto.addRecipeToRecipeList(recipeDto);
        return personMapper.mapp(personRepository.save(personMapper.mapp(personDto)));
    }
//
//    public PersonDto removeIngredientFromGroceryList(Long personId, Long ingredientId) {
//        PersonDto personDto = findPersonById(personId).get();
//        IngredientDto ingredientDto = ingredientService.getIngredientById(ingredientId);
//        person.removeIngredientFromGroceryList(ingredient);
//        return personMapper.mapp(personRepository.save(person));
//    }
//
//    public PersonDto removeRecipeFromRecipeList(Long personId, Long recipeId) {
//        PersonDto personDto = findPersonById(personId).get();
//        Recipe recipe = recipeService.findById(recipeId).get();
//        person.removeRecipeFromRecipeList(recipe);
//        return personMapper.mapp(personRepository.save(person));
//    }
}
