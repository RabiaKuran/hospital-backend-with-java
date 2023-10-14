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

import hospital.backend.business.abstracts.NotificationsService;
import hospital.backend.core.utilities.results.DataResult;
import hospital.backend.core.utilities.results.Result;
import hospital.backend.entities.concretes.Notifications;

@RestController
@RequestMapping(value="/api/notifications/")
public class NotificationsController {
	private NotificationsService notificationsService;

	@Autowired
	public NotificationsController(NotificationsService notificationsService) {
		super();
		this.notificationsService = notificationsService;
	}
	
	@GetMapping(value="getall")
	public DataResult<List<Notifications>> getAll() {
		return this.notificationsService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Notifications notifications) {
		return notificationsService.add(notifications);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Notifications notifications) {
		return notificationsService.update(notifications);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return notificationsService.delete(id);
	}

}
