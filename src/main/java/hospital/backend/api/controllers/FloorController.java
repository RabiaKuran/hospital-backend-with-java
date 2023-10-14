package hospital.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.backend.business.abstracts.FloorService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.entities.concretes.Floor;

@RestController
@RequestMapping(value="/api/floor")
public class FloorController {
	
	private FloorService floorService;

	@Autowired
	public FloorController(FloorService floorService) {
		super();
		this.floorService = floorService;
	}
	
	@GetMapping(value="/getall")
	public DataResult<List<Floor>> getAll() {
		return this.floorService.getAll();
	}
	
}