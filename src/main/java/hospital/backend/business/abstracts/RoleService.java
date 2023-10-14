package hospital.backend.business.abstracts;

import hospital.backend.entities.concretes.Role;

public interface RoleService {
	
	public Iterable<Role> getAll();
}