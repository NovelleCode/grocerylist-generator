package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
