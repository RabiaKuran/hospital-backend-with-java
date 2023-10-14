
package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.MblUserTable;

public interface MblUserService extends BaseEntityService<MblUserTable> {
	
	DataResult<List<MblUserTable>> getAll();
	void deleteByUserName(String userName);
	
	
}


