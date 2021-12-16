package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.grocerylistgenerator.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
