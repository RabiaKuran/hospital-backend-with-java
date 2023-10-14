package hospital.backend.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hospital.backend.entities.concretes.Patients;

public interface PatientsDao extends JpaRepository<Patients, Integer> {
	
	
	@Query(value= "SELECT *"
	 		+ " FROM churn WHERE run_id = (SELECT MAX(run_id) from churn) ORDER BY id ASC LIMIT 10", nativeQuery = true)
    List<Patients> getByChurnByPrediction();
	Patients findByUserName(String adSoyad);
	Optional<Patients> findById(Long id);
	
	

}