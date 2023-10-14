package hospital.backend.business.concretes;

import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.RoleService;
import hospital.backend.dataAccess.abstracts.RoleDao;
import hospital.backend.entities.concretes.Role;

@Service
public class RoleManager implements RoleService{
	
	private RoleDao roleDao;
	
	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}

	public Iterable<Role> getAll() {
		return roleDao.findAll();
	}
}