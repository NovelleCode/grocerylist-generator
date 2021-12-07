package se.iths.grocerylistgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Store;

@Repository
public interface StoreRepository extends CrudRepository <Store, Long> {
    Store findByName (String name);
}
