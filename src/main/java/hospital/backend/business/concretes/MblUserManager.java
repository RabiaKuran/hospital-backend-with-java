package hospital.backend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.MblUserService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.core.utilities.results.SuccessResult;
import hospital.backend.dataAccess.abstracts.MblUserDao;
import hospital.backend.entities.concretes.MblUserTable;


@Service
public class MblUserManager implements MblUserService{

	private MblUserDao mblUserDao;
	
	@Autowired
	public MblUserManager(MblUserDao mblUserDao) {
		super();
		this.mblUserDao = mblUserDao;
	}
	
	@Override
	public Result add(MblUserTable mblUserTable) {
		mblUserDao.save(mblUserTable);
		return new SuccessResult("Kullancı eklendi.");
	}

	public List<MblUserTable> getAllUsers() {
		return mblUserDao.findAll();
	}

	public MblUserTable saveOneUser(MblUserTable newUser) {
		return mblUserDao.save(newUser);
	}


	public MblUserTable updateOneUser(Long userId, MblUserTable newUser) {
		Optional<MblUserTable> user = mblUserDao.findById(userId);
		if(user.isPresent()) {
			MblUserTable foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			foundUser.setEMail(newUser.getEMail());
			foundUser.setTelefon(newUser.getTelefon());
			mblUserDao.save(foundUser);
			return foundUser;
		}else
			return null;
	}

	public MblUserTable getOneUserByUserName(String userName) {
		return mblUserDao.findByUserName(userName);
	}

	public DataResult<List<MblUserTable>> getAll() {
		return new SuccessDataResult<List<MblUserTable>>(this.mblUserDao.findAll(), "Users are listed.");
	}

	public void deleteByUserName(String userName) {
		mblUserDao.findByUserName(userName);
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
