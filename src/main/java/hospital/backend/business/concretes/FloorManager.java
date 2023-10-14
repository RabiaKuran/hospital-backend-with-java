package hospital.backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.FloorService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.dataAccess.abstracts.FloorDao;
import hospital.backend.entities.concretes.Floor;

@Service
public class FloorManager implements FloorService {
	
	private FloorDao floorDao;

	@Autowired
	public FloorManager(FloorDao floorDao) {
		super();
		this.floorDao = floorDao;
	}

	@Override
	public DataResult<List<Floor>> getAll() {
		return new SuccessDataResult<List<Floor>>(this.floorDao.findAll(), "Data listelendi.");
	}

}