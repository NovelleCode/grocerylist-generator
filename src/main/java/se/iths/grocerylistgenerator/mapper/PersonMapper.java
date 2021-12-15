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

    private final IngredientMapper ingredientMapper;
    private final RecipeMapper recipeMapper;

    public PersonMapper(IngredientMapper ingredientMapper, RecipeMapper recipeMapper) {
        this.ingredientMapper = ingredientMapper;
        this.recipeMapper = recipeMapper;
    }

    public Person mapp(AddPersonDto addPersonDto) {
        return new Person(addPersonDto.getUsername(), addPersonDto.getPassword());
    }

    public PersonDto mapp(Person person) {
        return new PersonDto(person.getId(), person.getUsername(), ingredientMapper.mapp(person.getGroceries()), recipeMapper.mapp(person.getRecipes()), person.getFavouriteStore());
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
