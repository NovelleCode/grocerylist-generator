package se.iths.grocerylistgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.grocerylistgenerator.mapper.PersonMapper;
import se.iths.grocerylistgenerator.repository.PersonRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository mockedPersonRepository;
    @Mock
    private RecipeService mockedRecipeService;
    @Mock
    private IngredientService mockedIngredientService;
    @Mock
    private StoreService mockedStoreService;
    @Mock
    private PersonMapper mockedPersonMapper;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(mockedPersonRepository, mockedRecipeService, mockedIngredientService, mockedStoreService, mockedPersonMapper);
    }

    @Test
    void findAllPersonsCallsRepository() {
        personService.findAllPersons();
        verify(mockedPersonRepository).findAll();
    }
}