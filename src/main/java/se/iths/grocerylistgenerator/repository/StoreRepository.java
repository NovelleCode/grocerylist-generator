package se.iths.grocerylistgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Store;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository <Store, Long> {
    Optional<Store> findByName(String name);
}
