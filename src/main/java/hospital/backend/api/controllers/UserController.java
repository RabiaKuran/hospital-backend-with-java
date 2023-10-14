package hospital.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.UserService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.UserTable;

@RestController
@RequestMapping("/api/users/")
public class UserController implements UserService{
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("getAllUsers")
	@Override
	public DataResult<List<UserTable>> getAll() {
		return this.userService.getAll();
	}

	//refresh tokenda fk önce oradan silmek gerekiyor, şu an bu metot çalışmıyor
	@PostMapping("deleteUser")
	@Override
	public void deleteByUserName(String userName) {
		userService.deleteByUserName(userName);
	}
	
}