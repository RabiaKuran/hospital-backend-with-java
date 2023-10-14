package hospital.backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.backend.business.abstracts.ProductsService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.core.utilities.results.SuccessDataResult;
import hospital.backend.core.utilities.results.SuccessResult;
import hospital.backend.dataAccess.abstracts.ProductsDao;
import hospital.backend.entities.concretes.Products;

@Service
public class ProductsManager implements ProductsService {
	
	private ProductsDao productsDao;

	@Autowired
	public ProductsManager(ProductsDao productsDao) {
		super();
		this.productsDao = productsDao;
	}
	@Override
	public Result add(Products products) {
		productsDao.save(products);
		return new SuccessResult("Ürün eklendi.");
	}

	@Override
	public Result update(Products products) {
		productsDao.save(products); 
		return new SuccessResult("Ürün güncellendi.");
	}

	@Override
	public Result delete(int id) {
		productsDao.deleteById(id);
		return new SuccessResult("Ürün silindi.");
	}

	@Override
	public DataResult<List<Products>> getAll() {
		return new SuccessDataResult<List<Products>>(this.productsDao.findAll(), "Data listelendi.");
	}
	@Override
	public DataResult<Products> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}