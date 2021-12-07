package se.iths.grocerylistgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
