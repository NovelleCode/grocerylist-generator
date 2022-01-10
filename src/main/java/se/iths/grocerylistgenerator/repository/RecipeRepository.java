package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.entity.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("select r from Recipe r join r.ingredients i where i.id in :ingredientIds")
    Set<Recipe> findRecipesThatMatchIngredientIds(@Param("ingredientIds")List<Long> ingredientIds);

    Optional<Recipe> findByName(String name);
}
