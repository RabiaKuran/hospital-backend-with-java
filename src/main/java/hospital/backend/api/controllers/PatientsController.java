package hospital.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.PatientsService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.entities.concretes.Patients;

@RestController
@RequestMapping(value="/api/patient/")
public class PatientsController implements PatientsService{
	
	private PatientsService patientsService;

	@Autowired
	public PatientsController(PatientsService patientsService) {
		super();
		this.patientsService = patientsService;
	}
	
	
	@GetMapping(value="/getall")
	public DataResult<List<Patients>> getAll() {
		return this.patientsService.getAll();
	}
	
	
	@GetMapping(value="/getByChurnByPrediction")
	public DataResult<List<Patients>> getByChurnByPrediction() {
		return this.patientsService.getByChurnByPrediction();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Patients patients) {
		return patientsService.add(patients);
	}

	@PostMapping("deleteUser")
	@Override
	public void deleteByUserName(String adSoyad) {
		patientsService.deleteByUserName(adSoyad);
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
	
}