package se.iths.grocerylistgenerator.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "person_ingredients",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> groceries = new HashSet<>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "person_recipe",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store favouriteStore;


    public Person(String username, String password, Role role, Store favouriteStore) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.favouriteStore = favouriteStore;
    }

    public Person(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person() {
    }

    public void addIngredientToGroceryList(Ingredient ingredient) {
        groceries.add(ingredient);
    }

    public void addRecipeToRecipesList(Recipe recipe) {
        recipes.add(recipe);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Ingredient> getGroceries() {
        return groceries;
    }

    public void setGroceries(Set<Ingredient> groceries) {
        this.groceries = groceries;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Store getFavouriteStore() {
        return favouriteStore;
    }

    public void setFavouriteStore(Store favouriteStore) {
        this.favouriteStore = favouriteStore;
    }
}
