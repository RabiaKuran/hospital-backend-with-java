package hospital.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.ProductsService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.entities.concretes.Products;

@RestController
@RequestMapping(value="/api/products/")
public class ProductsController {
	
	private ProductsService productsService;

	@Autowired
	public ProductsController(ProductsService productsService) {
		super();
		this.productsService = productsService;
	}
	
	@GetMapping(value="getall")
	public DataResult<List<Products>> getAll() {
		return this.productsService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Products products) {
		return productsService.add(products);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Products products) {
		return productsService.update(products);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return productsService.delete(id);
	}
	
	
}