package se.iths.grocerylistgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.grocerylistgenerator.dto.AddPersonDto;
import se.iths.grocerylistgenerator.entity.Person;
import se.iths.grocerylistgenerator.exception.BadRequestException;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
import se.iths.grocerylistgenerator.repository.PersonRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository mockedPersonRepository;
    @Mock
    private RecipeService recipeService;
    @Mock
    private IngredientService ingredientService;
    @Mock
    private StoreService storeService;
    @Mock
    private PersonMapper personMapper;


    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(mockedPersonRepository,recipeService, ingredientService, storeService, personMapper);
    }

    @Test
    void createPersonWithCorrectInputCallsRepositoryWithCorrectArgument() {
        AddPersonDto personDto = new AddPersonDto("Nisse", "123");
        Person person = new Person("Nisse", "123");

        when(personMapper.mapp(personDto)).thenReturn(person);
        personService.createPerson(personDto);

        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
        verify(mockedPersonRepository).save(personArgumentCaptor.capture());

        Person capturedPerson = personArgumentCaptor.getValue();
        assertThat(capturedPerson).isEqualTo(person);
    }

    @Test
    void createPersonWithEmptyUsernameWillThrowException() {
        AddPersonDto personDto = new AddPersonDto("", "123");

        assertThatThrownBy(() -> personService.createPerson(personDto))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Invalid input in request body");

        verify(mockedPersonRepository, never()).save(any());
    }

    @Test
    void findAllPersonsCallsRepository() {
        personService.findAllPersons();
        verify(mockedPersonRepository).findAll();
    }
}