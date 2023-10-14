package hospital.backend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.backend.entities.concretes.Products;


public interface ProductsDao extends JpaRepository<Products, Integer> {
	

	 
}