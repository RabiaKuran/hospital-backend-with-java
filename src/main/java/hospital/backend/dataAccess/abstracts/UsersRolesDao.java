package hospital.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.backend.entities.concretes.UsersRoles;

public interface UsersRolesDao extends JpaRepository<UsersRoles, Long> {
	 
}