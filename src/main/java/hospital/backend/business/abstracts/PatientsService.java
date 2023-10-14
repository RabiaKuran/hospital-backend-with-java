package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Patients;

public interface PatientsService extends BaseEntityService<Patients> {
	
	DataResult<List<Patients>> getAll();
	DataResult<List<Patients>> getByChurnByPrediction();
	void deleteByUserName(String adSoyad);
}