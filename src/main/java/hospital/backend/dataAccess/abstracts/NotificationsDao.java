package hospital.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.backend.entities.concretes.Notifications;


public interface NotificationsDao extends JpaRepository<Notifications, Integer> {
	
}
	 