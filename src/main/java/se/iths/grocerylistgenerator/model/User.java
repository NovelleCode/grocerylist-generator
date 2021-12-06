package se.iths.grocerylistgenerator.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    private Role role;

    @ManyToMany
    private Set<Ingredient> groceries;

    @ManyToMany
    private Set<Recipe> recipes;

    @ManyToOne
    private Store favouriteStore;

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
