package garage.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import garage.spring.entities.GarageEntity;
import garage.spring.service.IGarageService;

@RestController
@RequestMapping(value = "/api-garage")
@CrossOrigin("http://localhost:4200")
public class GarageController {
	@Autowired
	private IGarageService garageService;
	
	@GetMapping(value = "/v0/all")
	public List<GarageEntity> getAllGarage(){
		List<GarageEntity> garage=garageService.getAllGarage();
	return	garage;
	}
	
	@PostMapping(value = "/v0/add")
	public GarageEntity saveGarage(@RequestBody GarageEntity g) {
		GarageEntity save=garageService.saveGarage(g);
		return save;
	}
	
	@DeleteMapping(value = "/v0/garageDelete/{id}")
	public void deleteGarage(@PathVariable Long id) {
		garageService.deleteGarage(id);
	}
	@GetMapping(value = "/v0/garage/{id}")
	public GarageEntity getGarageById(@PathVariable Long id) {
		GarageEntity g=garageService.getOneGarage(id);
		return g ;
	}
	@PutMapping(value = "/v0/garageUpdate/{id}")
	public GarageEntity updateGarage(@PathVariable Long id,@RequestBody GarageEntity g)  {
		return garageService.updateGarage(g);
	}
	
}
