package se.iths.grocerylistgenerator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.dto.PersonDto;
import se.iths.grocerylistgenerator.entity.Person;
import se.iths.grocerylistgenerator.entity.Role;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.repository.PersonRepository;
import se.iths.grocerylistgenerator.repository.RoleRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class GrocerylistGeneratorApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RoleRepository roleRepository;

    @BeforeEach
    void setUp() {

        Person person1 = new Person("Kalle", "123");
        Person person2 = new Person("Mia", "456");
        Person person3 = new Person("Nisse", "789");

        Role role = new Role("ROLE_USER");

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        roleRepository.save(role);
    }

    @AfterEach
    void tearDown() {
        personRepository.deleteAll();
    }

    @Test
    void testSignupNewPersonReturnsPersonDtoStatusCreatedAndPersonHasCorrectRole() {
        AddPersonDto addPersonDto = new AddPersonDto("Anna", "147");
        var createPersonResult = testRestTemplate.
                postForEntity("http://localhost:" + port + "/signup", addPersonDto, PersonDto.class);
        assertThat(createPersonResult.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(Objects.requireNonNull(createPersonResult.getBody()).getUsername()).isEqualTo(addPersonDto.getUsername());

        List<Person> all = personRepository.findAll();
        assertThat(all.size()).isEqualTo(4);

        Optional<Person> person = personRepository.findById(createPersonResult.getBody().getId());
        person.ifPresent(value -> assertThat(value.getRole().getRoleName()).isEqualTo("ROLE_USER"));
    }

    @Test
    void testSignupNewPersonReturnsBadRequest() {

        AddPersonDto addPersonDto = new AddPersonDto("Kalle", "147");
        var result = testRestTemplate.
                postForEntity("http://localhost:" + port + "/signup", addPersonDto, BadRequestException.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        List<Person> all2 = personRepository.findAll();
        assertThat(all2.size()).isEqualTo(3);
    }
}
