package hospital.backend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.UserService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.dataAccess.abstracts.UserDao;
import hospital.backend.entities.concretes.UserTable;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public List<UserTable> getAllUsers() {
		return userDao.findAll();
	}

	public UserTable saveOneUser(UserTable newUser) {
		return userDao.save(newUser);
	}

	public UserTable getOneUserById(Long userId) {
		return userDao.findById(userId).orElse(null);
	}

	public UserTable updateOneUser(Long userId, UserTable newUser) {
		Optional<UserTable> user = userDao.findById(userId);
		if(user.isPresent()) {
			UserTable foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			foundUser.setEMail(newUser.getEMail());
			userDao.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public UserTable getOneUserByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public DataResult<List<UserTable>> getAll() {
		return new SuccessDataResult<List<UserTable>>(this.userDao.findAll(), "Users are listed.");
	}

	public void deleteByUserName(String userName) {
		userDao.deleteByUserName(userName);
	}
}