package se.iths.grocerylistgenerator.model;

import org.apache.catalina.Store;

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

//    @ManyToOne
//    private Role role;

//    @ManyToMany()
//    private Set<Ingredient> groceries = new HashSet<>();
//
//    @ManyToMany()
//    private Set<Recipe> recipes = new HashSet<>();
//
//    @ManyToOne
//    private Store favouriteStore;
//
//    public User(String username, String password, Role role, Set<Ingredient> groceries, Set<Recipe> recipes, Store favouriteStore) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.groceries = groceries;
//        this.recipes = recipes;
//        this.favouriteStore = favouriteStore;
//    }
//


    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Person() {
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

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public Set<Ingredient> getGroceries() {
//        return groceries;
//    }
//
//    public void setGroceries(Set<Ingredient> groceries) {
//        this.groceries = groceries;
//    }
//
//    public Set<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(Set<Recipe> recipes) {
//        this.recipes = recipes;
//    }

//    public Store getFavouriteStore() {
//        return favouriteStore;
//    }
//
//    public void setFavouriteStore(Store favouriteStore) {
//        this.favouriteStore = favouriteStore;
//    }
}
