package hospital.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.backend.entities.concretes.RefreshToken;

public interface RefreshTokenDao extends JpaRepository<RefreshToken, Long>{
	
	RefreshToken findByUserId(Long userId);
}