package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.UserTable;


public interface UserService {
	
	DataResult<List<UserTable>> getAll();
	void deleteByUserName(String userName);
}