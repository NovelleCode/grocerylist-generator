package se.iths.grocerylistgenerator.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.entity.Person;
import se.iths.grocerylistgenerator.entity.Role;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
import se.iths.grocerylistgenerator.repository.PersonRepository;
import se.iths.grocerylistgenerator.repository.RoleRepository;

import java.util.Optional;

@Service
public class SignupService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final PersonMapper personMapper;
    private final PasswordEncoder passwordEncoder;

    public SignupService(PersonRepository personRepository,RoleRepository roleRepository, PersonMapper personMapper, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.personMapper = personMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public PersonDto createPerson(AddPersonDto addPersonDto) {
        isValidAddPersonDto(addPersonDto);
        checkUsernameNotTaken(addPersonDto);
        addPersonDto.setPassword(passwordEncoder.encode(addPersonDto.getPassword()));
        Role userRole = roleRepository.findByRoleName("ROLE_USER");
        return personMapper.mapp(personRepository.save(personMapper.mapp(addPersonDto, userRole)));
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

}
