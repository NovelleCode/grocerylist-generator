package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonMapper {

    private final IngredientMapper ingredientMapper;
    private final RecipeMapper recipeMapper;
    private final StoreMapper storeMapper;

    public PersonMapper(IngredientMapper ingredientMapper, RecipeMapper recipeMapper, StoreMapper storeMapper) {
        this.ingredientMapper = ingredientMapper;
        this.recipeMapper = recipeMapper;
        this.storeMapper = storeMapper;
    }

    public Person mapp(AddPersonDto addPersonDto) {
        return new Person(addPersonDto.getUsername(), addPersonDto.getPassword());
    }

    public PersonDto mapp(Person person) {
        if(person.getFavouriteStore() == null){
            return new PersonDto(person.getId(), person.getUsername(), ingredientMapper.mapp(person.getGroceries())
                    , recipeMapper.mapp(person.getRecipes()));
        } else {
            return new PersonDto(person.getId(), person.getUsername(), ingredientMapper.mapp(person.getGroceries())
                    , recipeMapper.mapp(person.getRecipes()), storeMapper.mapp(person.getFavouriteStore()));
        }

    }

    public List<PersonDto> mapp(List<Person> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

//    public Optional<PersonDto> mapp(Person optionalPerson) {
//        if (optionalPerson.isEmpty())
//            return Optional.empty();
//        return Optional.of(mapp(optionalPerson.get()));
//    }
}
