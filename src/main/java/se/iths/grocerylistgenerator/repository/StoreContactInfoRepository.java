package se.iths.grocerylistgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.StoreContactInfo;

@Repository
public interface StoreContactInfoRepository extends CrudRepository<StoreContactInfo, Long> {
}