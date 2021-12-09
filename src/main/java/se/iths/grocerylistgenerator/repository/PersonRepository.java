package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
