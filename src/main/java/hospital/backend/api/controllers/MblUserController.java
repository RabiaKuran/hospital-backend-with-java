package hospital.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.MblUserService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.entities.concretes.MblUserTable;

@RestController
@RequestMapping("/api/mblusers/")
public class MblUserController implements MblUserService{
	
	private MblUserService mblUserService;
	
	@Autowired
	public MblUserController(MblUserService mbluserService) {
		super();
		this.mblUserService = mbluserService;
	}

	@GetMapping("getAllUsers")
	@Override
	public DataResult<List<MblUserTable>> getAll() {
		return this.mblUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MblUserTable mblUserTable) {
		return mblUserService.add(mblUserTable);
	}

	@PostMapping("deleteUser")
	@Override
	public void deleteByUserName(String userName) {
		mblUserService.deleteByUserName(userName);
	}

	@Override
	public Result update(MblUserTable entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<MblUserTable> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
	