package hospital.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.EmployeesService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Employees;


@RestController
@RequestMapping(value="/api/employees")
public class EmployeesController {
	
	private EmployeesService employeesService;

	@Autowired
	public EmployeesController(EmployeesService employeesService) {
		super();
		this.employeesService = employeesService;
	}
	
	@GetMapping(value="/getall")
	public DataResult<List<Employees>> getAll() {
		return this.employeesService.getAll();
	}
	
}