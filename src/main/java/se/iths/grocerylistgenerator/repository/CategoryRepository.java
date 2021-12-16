package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.grocerylistgenerator.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
