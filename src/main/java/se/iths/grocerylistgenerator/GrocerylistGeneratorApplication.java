package se.iths.grocerylistgenerator;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.grocerylistgenerator.entity.*;
import se.iths.grocerylistgenerator.repository.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GrocerylistGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrocerylistGeneratorApplication.class, args);
    }

//    @Bean
//    public ApplicationRunner setUp(StoreRepository storeRepository, CategoryRepository categoryRepository,
//                                   IngredientRepository ingredientRepository, RecipeRepository recipeRepository,
//                                   RoleRepository roleRepository) {
//        return args -> {
//            storeRepository.save(new Store("ICA Maxi Högsbo", new ContactInfo("Lona Knapes Gata 1, 421 32 Västa Frölunda", "0317127100")));
//            storeRepository.save(new Store("Willys Göteborg Elisedal", new ContactInfo("Scoutgatan 11, 412 65 Göteborg", "0313636780")));
//            storeRepository.save(new Store("ICA Maxi Göteborg", new ContactInfo("Grafiska vägen 16, 412 63 Göteborg", "0317466100")));
//            storeRepository.save(new Store("Hemköp Bifrost", new ContactInfo("Pinnharvsgatan 11, 431 47 Mölndal", "0727133801")));
//            storeRepository.save(new Store("Stora Coop Sisjön", new ContactInfo("Hantverksvägen 2, 436 33 Askim", "0107415630")));
//
//            Category vegetables = new Category("vegetables");
//            Category fruit = new Category("fruit");
//            Category meat = new Category("meat");
//            Category fish = new Category("fish");
//            Category bread = new Category("bread");
//            Category dairy = new Category("dairy");
//            Category pantry = new Category("pantry food");
//            Category frozen = new Category("frozen food");
//            Category sweetsSnacks = new Category("sweets and snacks");
//            Category beverages = new Category("beverages");
//
//            categoryRepository.save(vegetables);
//            categoryRepository.save(fruit);
//            categoryRepository.save(meat);
//            categoryRepository.save(fish);
//            categoryRepository.save(bread);
//            categoryRepository.save(dairy);
//            categoryRepository.save(pantry);
//            categoryRepository.save(frozen);
//            categoryRepository.save(sweetsSnacks);
//            categoryRepository.save(beverages);
//
//            Ingredient spaghetti = new Ingredient("spaghetti");
//            Ingredient meatballs = new Ingredient("meatballs");
//            Ingredient tomatosauce = new Ingredient("tomatosauce");
//            Ingredient eggs = new Ingredient("eggs");
//            Ingredient apples = new Ingredient("apples");
//            Ingredient sugar = new Ingredient("sugar");
//            Ingredient butter = new Ingredient("butter");
//            Ingredient flour = new Ingredient("flour");
//            Ingredient mincedMeat = new Ingredient("minced meat");
//            Ingredient tortilla = new Ingredient("tortillas");
//            Ingredient paprika = new Ingredient("paprika");
//            Ingredient tacoseasoning = new Ingredient("taco seasoning");
//            Ingredient salsa = new Ingredient("salsa sauce");
//            Ingredient cheese = new Ingredient("cheese");
//            Ingredient lettuce = new Ingredient("iceberg lettuce");
//            Ingredient milk = new Ingredient("milk");
//            Ingredient feta = new Ingredient("feta cheese");
//            Ingredient cucumber = new Ingredient("cucumber");
//            Ingredient tomatoes = new Ingredient("tomatoes");
//            Ingredient redOnion = new Ingredient("red onion");
//            Ingredient crisps = new Ingredient("crisps");
//            Ingredient chocolate = new Ingredient("chocolate");
//            Ingredient lasagneSheets = new Ingredient("lasagne sheets");
//            Ingredient iceCream = new Ingredient("ice cream");
//            Ingredient salmon = new Ingredient("salmon");
//            Ingredient coke = new Ingredient("coke");
//            Ingredient knäckebröd = new Ingredient("knäckebröd");
//
//
//            ingredientRepository.save(spaghetti);
//            ingredientRepository.save(meatballs);
//            ingredientRepository.save(tomatosauce);
//            ingredientRepository.save(eggs);
//            ingredientRepository.save(apples);
//            ingredientRepository.save(sugar);
//            ingredientRepository.save(butter);
//            ingredientRepository.save(flour);
//            ingredientRepository.save(mincedMeat);
//            ingredientRepository.save(tortilla);
//            ingredientRepository.save(paprika);
//            ingredientRepository.save(tacoseasoning);
//            ingredientRepository.save(salsa);
//            ingredientRepository.save(cheese);
//            ingredientRepository.save(lettuce);
//            ingredientRepository.save(milk);
//            ingredientRepository.save(feta);
//            ingredientRepository.save(cucumber);
//            ingredientRepository.save(tomatoes);
//            ingredientRepository.save(redOnion);
//            ingredientRepository.save(crisps);
//            ingredientRepository.save(chocolate);
//            ingredientRepository.save(lasagneSheets);
//            ingredientRepository.save(iceCream);
//            ingredientRepository.save(salmon);
//            ingredientRepository.save(coke);
//            ingredientRepository.save(knäckebröd);
//
//            spaghetti.setCategory(pantry);
//            meatballs.setCategory(meat);
//            tomatosauce.setCategory(pantry);
//            eggs.setCategory(dairy);
//            apples.setCategory(fruit);
//            sugar.setCategory(pantry);
//            butter.setCategory(dairy);
//            flour.setCategory(pantry);
//            mincedMeat.setCategory(meat);
//            tortilla.setCategory(bread);
//            paprika.setCategory(vegetables);
//            tacoseasoning.setCategory(pantry);
//            salsa.setCategory(pantry);
//            cheese.setCategory(dairy);
//            lettuce.setCategory(vegetables);
//            milk.setCategory(dairy);
//            feta.setCategory(dairy);
//            cucumber.setCategory(vegetables);
//            tomatoes.setCategory(vegetables);
//            redOnion.setCategory(vegetables);
//            crisps.setCategory(sweetsSnacks);
//            chocolate.setCategory(sweetsSnacks);
//            lasagneSheets.setCategory(pantry);
//            iceCream.setCategory(frozen);
//            salmon.setCategory(fish);
//            coke.setCategory(beverages);
//            knäckebröd.setCategory(bread);
//
//            ingredientRepository.save(spaghetti);
//            ingredientRepository.save(meatballs);
//            ingredientRepository.save(tomatosauce);
//            ingredientRepository.save(eggs);
//            ingredientRepository.save(apples);
//            ingredientRepository.save(sugar);
//            ingredientRepository.save(butter);
//            ingredientRepository.save(flour);
//            ingredientRepository.save(mincedMeat);
//            ingredientRepository.save(tortilla);
//            ingredientRepository.save(paprika);
//            ingredientRepository.save(tacoseasoning);
//            ingredientRepository.save(salsa);
//            ingredientRepository.save(cheese);
//            ingredientRepository.save(lettuce);
//            ingredientRepository.save(milk);
//            ingredientRepository.save(feta);
//            ingredientRepository.save(cucumber);
//            ingredientRepository.save(tomatoes);
//            ingredientRepository.save(redOnion);
//            ingredientRepository.save(crisps);
//            ingredientRepository.save(chocolate);
//            ingredientRepository.save(lasagneSheets);
//            ingredientRepository.save(iceCream);
//            ingredientRepository.save(salmon);
//            ingredientRepository.save(coke);
//            ingredientRepository.save(knäckebröd);
//
//            Recipe recipe1 = new Recipe("Pasta Bolognese");
//            Recipe recipe2 = new Recipe("Omelette");
//            Recipe recipe3 = new Recipe("Apple pie");
//            Recipe recipe4 = new Recipe("Tacos");
//            Recipe recipe5 = new Recipe("Pancakes");
//            Recipe recipe6 = new Recipe("Greek feta salad");
//            Recipe recipe7 = new Recipe("Lasagne");
//
//            recipeRepository.save(recipe1);
//            recipeRepository.save(recipe2);
//            recipeRepository.save(recipe3);
//            recipeRepository.save(recipe4);
//            recipeRepository.save(recipe5);
//            recipeRepository.save(recipe6);
//            recipeRepository.save(recipe7);
//
//            recipe1.setIngredients(new HashSet<>(Set.of(spaghetti, meatballs, tomatosauce)));
//            recipe2.setIngredients(new HashSet<>(Set.of(eggs)));
//            recipe3.setIngredients(new HashSet<>(Set.of(eggs, apples, sugar, flour, butter)));
//            recipe4.setIngredients(new HashSet<>(Set.of(mincedMeat, tortilla, cheese, salsa, tacoseasoning, lettuce, paprika)));
//            recipe5.setIngredients(new HashSet<>(Set.of(eggs, milk, butter)));
//            recipe6.setIngredients(new HashSet<>(Set.of(feta, cucumber, tomatoes, redOnion)));
//            recipe7.setIngredients(new HashSet<>(Set.of(tomatosauce, mincedMeat, lasagneSheets)));
//
//            recipeRepository.save(recipe1);
//            recipeRepository.save(recipe2);
//            recipeRepository.save(recipe3);
//            recipeRepository.save(recipe4);
//            recipeRepository.save(recipe5);
//            recipeRepository.save(recipe6);
//            recipeRepository.save(recipe7);
//
//            roleRepository.save(new Role("ROLE_USER"));
//            roleRepository.save(new Role("ROLE_ADMIN"));
//        };
//    }
}
