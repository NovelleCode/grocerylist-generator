package se.iths.grocerylistgenerator.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.iths.grocerylistgenerator.entity.Category;
import se.iths.grocerylistgenerator.entity.Ingredient;
import se.iths.grocerylistgenerator.entity.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository testRecipeRepository;

    private Recipe testRecipeSalad;
    private Recipe testRecipeOmelette;

    private Ingredient tomato;
    private Ingredient cucumber;
    private Ingredient egg;


    @BeforeEach
    void setUp() {

        Category vegetableCategory = new Category("vegetable");
        Category dairyCategory = new Category("dairy");

        tomato = new Ingredient("tomato", vegetableCategory);
        cucumber = new Ingredient("cucumber", vegetableCategory);
        egg = new Ingredient("egg", dairyCategory);

        testRecipeSalad = new Recipe("salad", Set.of(tomato, cucumber));
        testRecipeOmelette = new Recipe("omelette", Set.of(egg));
        testRecipeRepository.save(testRecipeSalad);
        testRecipeRepository.save(testRecipeOmelette);
    }

    @AfterEach
    void tearDown() {
        testRecipeRepository.deleteAll();
    }

    @Test
    void findByNameReturnsRecipe() {
        Optional<Recipe> result = testRecipeRepository.findByName("omelette");
        assertThat(result).contains(testRecipeOmelette);
    }

    @Test
    void findByNameReturnsEmpty() {
        Optional<Recipe> result = testRecipeRepository.findByName("spagetti");
        assertThat(result).isEmpty();
    }

    @Test
    void findRecipeByIngredient() {
        Set<Recipe> result = testRecipeRepository.findRecipesThatMatchIngredientIds(List.of(cucumber.getId()));
        assertThat(result).isEqualTo(Set.of(testRecipeSalad));
    }
}