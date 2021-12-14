package se.iths.grocerylistgenerator.mapper;

import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.model.Person;

public class PersonMapper {

    public PersonMapper() {
    }

    public PersonDto mapp(Person person) {
        return new PersonDto(person.getId(), person.getUsername());
    }

    public Person mapp(PersonDto personDto) {
        return new Person(personDto.getUsername(), personDto.getPassword());
    }
}
