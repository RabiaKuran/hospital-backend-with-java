package hospital.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospital.backend.entities.concretes.UserTable;

@Repository
public interface UserDao extends JpaRepository<UserTable, Long> {

	UserTable findByUserName(String userName);
	
	//önce refresh token tablosundan silmek gerektiği için şu anda bu metot çalışmıyor..
	@Query("delete from UserTable u where u.userName = :userName")
	@Modifying
	@Transactional
	void deleteByUserName(String userName);
}