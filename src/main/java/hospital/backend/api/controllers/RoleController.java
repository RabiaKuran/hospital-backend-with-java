package hospital.backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.RoleService;
import hospital.backend.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles/")
public class RoleController implements RoleService {
	
	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	@GetMapping("getAll")
	@Override
	public Iterable<Role> getAll() {
		return this.roleService.getAll();
	}
}