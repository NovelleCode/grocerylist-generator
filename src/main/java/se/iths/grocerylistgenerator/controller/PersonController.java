package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.model.Person;
import se.iths.grocerylistgenerator.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persons")
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons(){
        List<Person> allPersons = personService.findAllPersons();
        return new ResponseEntity<>(allPersons, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Person>> findPersonById(@PathVariable Long id){
        Optional<Person> foundPerson = personService.findPersonById(id);
        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }


}
