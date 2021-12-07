package se.iths.grocerylistgenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.grocerylistgenerator.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRoleName(String roleName);
}
