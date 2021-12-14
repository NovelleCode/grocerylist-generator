package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.model.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonMapper {

    public PersonMapper() {
    }

    public Person mapp(AddPersonDto addPersonDto) {
        return new Person(addPersonDto.getUsername(), addPersonDto.getPassword());
    }

    public PersonDto mapp(Person person) {
        return new PersonDto(person.getId(), person.getUsername(), person.getGroceries(), person.getRecipes(), person.getFavouriteStore());
    }

    public List<PersonDto> mapp(List<Person> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
