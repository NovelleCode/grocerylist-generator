package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonMapper {

    IngredientMapper ingredientMapper;
    RecipeMapper recipeMapper;
    StoreMapper storeMapper;

    public PersonMapper(IngredientMapper ingredientMapper, RecipeMapper recipeMapper, StoreMapper storeMapper) {
        this.ingredientMapper = ingredientMapper;
        this.recipeMapper = recipeMapper;
        this.storeMapper = storeMapper;
    }

    public Person mapp(AddPersonDto addPersonDto) {
        return new Person(addPersonDto.getUsername(), addPersonDto.getPassword());
    }
    public Person mapp(PersonDto personDto) {
        return new Person(personDto.getId(), personDto.getUsername(), ingredientMapper.mappSetToIngredient(personDto.getGroceries()));
    }

    public PersonDto mapp(Person person) {
        return new PersonDto(person.getId(), person.getUsername(), ingredientMapper.mapp(person.getGroceries())
                , recipeMapper.mapp(person.getRecipes()), storeMapper.mapp(person.getFavouriteStore()));
    }

    public List<PersonDto> mapp(List<Person> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

    public Optional<PersonDto> mapp(Optional<Person> optionalPerson) {
        if (optionalPerson.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalPerson.get()));
    }
}
