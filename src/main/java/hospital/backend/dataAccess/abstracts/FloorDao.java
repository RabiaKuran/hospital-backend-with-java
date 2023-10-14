package hospital.backend.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import hospital.backend.entities.concretes.Floor;

public interface FloorDao extends JpaRepository<Floor, Long> {
	
	
}