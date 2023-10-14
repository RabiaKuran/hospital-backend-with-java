package hospital.backend.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import hospital.backend.entities.concretes.Employees;


public interface EmployeesDao extends JpaRepository<Employees, Integer> {
	
	
}