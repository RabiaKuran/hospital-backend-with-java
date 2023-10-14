package hospital.backend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.PatientsService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.core.utilities.results.SuccessResult;
import hospital.backend.dataAccess.abstracts.PatientsDao;
import hospital.backend.entities.concretes.Patients;


@Service
public class PatientsManager implements PatientsService {
	
	private PatientsDao patientsDao;

	@Autowired
	public PatientsManager(PatientsDao patientsDao) {
		super();
		this.patientsDao = patientsDao;
	}
	
	@Override
	public Result add(Patients patients) {
		patientsDao.save(patients);
		return new SuccessResult("Kullanıcı Eklendi");
	}
	public List<Patients> getAllUsers() {
		return patientsDao.findAll();
	}

	public Patients saveOneUser(Patients newUser) {
		return patientsDao.save(newUser);
	}


	public Patients updateOneUser(Long hId, Patients newUser) {
		Optional<Patients> user = patientsDao.findById(hId);
		if(user.isPresent()) {
			Patients foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setCadSoyad(newUser.getCadSoyad());
			foundUser.setOdaNo(newUser.getOdaNo());
			foundUser.setRadSoyad(newUser.getRadSoyad());
			foundUser.setYatisSebebi(newUser.getYatisSebebi());
			foundUser.setTelefon(newUser.getTelefon());
			foundUser.setBirthDate(newUser.getBirthDate());
			foundUser.setGirisTarihi(newUser.getGirisTarihi());
			patientsDao.save(foundUser);
			return foundUser;
		}else
			return null;
	}


	@Override
	public Result update(Patients entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Patients> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
	
	public DataResult<List<Patients>> getAll() {
		return new SuccessDataResult<List<Patients>>(this.patientsDao.findAll(), "Data listelendi.");
	}

	@Override
	public DataResult<List<Patients>> getByChurnByPrediction() {
		return new SuccessDataResult<List<Patients>>(this.patientsDao.getByChurnByPrediction(), "Data listelendi.");
	}

	@Override
	public void deleteByUserName(String adSoyad) {
		// TODO Auto-generated method stub
		
	}
}