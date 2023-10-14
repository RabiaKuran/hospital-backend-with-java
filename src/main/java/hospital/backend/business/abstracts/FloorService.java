package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Floor;

public interface FloorService {
	
	DataResult<List<Floor>> getAll();
	
}