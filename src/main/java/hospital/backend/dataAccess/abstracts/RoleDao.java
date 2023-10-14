package hospital.backend.dataAccess.abstracts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hospital.backend.entities.concretes.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

}