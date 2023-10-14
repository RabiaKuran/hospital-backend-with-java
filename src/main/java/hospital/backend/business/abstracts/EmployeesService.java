package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Employees;


public interface EmployeesService {
	
	DataResult<List<Employees>> getAll();
	
}