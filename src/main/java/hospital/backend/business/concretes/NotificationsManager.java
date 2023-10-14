package hospital.backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.NotificationsService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.core.utilities.results.SuccessResult;
import hospital.backend.dataAccess.abstracts.NotificationsDao;
import hospital.backend.entities.concretes.Notifications;

@Service
public class NotificationsManager implements NotificationsService {
	
	private NotificationsDao notificationsDao;

	@Autowired
	public NotificationsManager(NotificationsDao notificationsDao) {
		super();
		this.notificationsDao = notificationsDao;
	}
	@Override
	public Result add(Notifications notifications) {
		notificationsDao.save(notifications);
		return new SuccessResult("Ürün eklendi.");
	}

	@Override
	public Result update(Notifications notifications) {
		notificationsDao.save(notifications); 
		return new SuccessResult("Ürün güncellendi.");
	}

	@Override
	public Result delete(int id) {
		notificationsDao.deleteById(id);
		return new SuccessResult("Ürün silindi.");
	}

	@Override
	public DataResult<List<Notifications>> getAll() {
		return new SuccessDataResult<List<Notifications>>(this.notificationsDao.findAll(), "Data listelendi.");
	}
	@Override
	public DataResult<Notifications> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}