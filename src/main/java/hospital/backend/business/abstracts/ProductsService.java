package hospital.backend.business.abstracts;

import java.util.List;

import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Products;

public interface ProductsService extends BaseEntityService<Products> {
	
	DataResult<List<Products>> getAll();
	
	
	
}