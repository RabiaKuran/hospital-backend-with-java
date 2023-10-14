package hospital.backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.EmployeesService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.dataAccess.abstracts.EmployeesDao;
import hospital.backend.entities.concretes.Employees;


@Service
public class EmployeesManager implements EmployeesService {
	
	private EmployeesDao employeesDao;

	@Autowired
	public EmployeesManager(EmployeesDao employeesDao) {
		super();
		this.employeesDao = employeesDao;
	}

	@Override
	public DataResult<List<Employees>> getAll() {
		return new SuccessDataResult<List<Employees>>(this.employeesDao.findAll(), "Data listelendi.");
	}

	

	
}