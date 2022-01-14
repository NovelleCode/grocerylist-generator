package se.iths.grocerylistgenerator.repository;

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



    @Test
    void findByUsername() {

        Person person = new Person("Kalle", "123");
        testPersonRepository.save(person);

        Optional<Person> result = testPersonRepository.findByUsername("Helena");

        assertThat(result).contains(person);
    }
}
