package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("select r from Recipe r join r.ingredients i where i.id in :ingredientIds")
    List<Recipe> findRecipesThatMatchIngredientIds(@Param("ingredientIds")List<Long> ingredientIds);
}
