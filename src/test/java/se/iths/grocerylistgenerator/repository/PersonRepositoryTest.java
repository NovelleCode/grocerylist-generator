package se.iths.grocerylistgenerator.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.iths.grocerylistgenerator.entity.Person;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository testPersonRepository;

    private Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = new Person("Kalle", "123");
        testPersonRepository.save(testPerson);
    }

    @AfterEach
    void tearDown() {
        testPersonRepository.deleteAll();
    }

    @Test
    void findByUsernameReturnsPerson() {
        Optional<Person> result = testPersonRepository.findByUsername("Kalle");
        assertThat(result).contains(testPerson);
    }

    @Test
    void findByUsernameReturnsEmpty() {
        Optional<Person> result = testPersonRepository.findByUsername("Musse");
        assertThat(result).isEmpty();
    }
}
