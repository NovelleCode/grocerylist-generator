package se.iths.grocerylistgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.service.SignupService;


@RestController
@RequestMapping()
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<PersonDto> createPerson(@RequestBody AddPersonDto addPersonDto){
        PersonDto createdPerson = signupService.createPerson(addPersonDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

/*    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }*/
}
