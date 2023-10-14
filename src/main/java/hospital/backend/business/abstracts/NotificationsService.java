package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Notifications;

public interface NotificationsService extends BaseEntityService<Notifications> {
	
	DataResult<List<Notifications>> getAll();
	
	
	
}