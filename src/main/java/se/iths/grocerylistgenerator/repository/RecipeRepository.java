package se.iths.grocerylistgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByIngredientsAndId(@Param("ingredientId")List<Long> ingredientId);
}
