
package hospital.backend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hospital.backend.entities.concretes.MblUserTable;

@Repository
public interface MblUserDao extends JpaRepository<MblUserTable, Integer> {

	MblUserTable findByUserName(String userName);

	Optional<MblUserTable> findById(Long userId);

	
}
