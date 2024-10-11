package spring_web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring_web.Model.City;
import spring_web.Service.CityService;

@RestController
@RequestMapping("/api2")
public class CityController {
	
	@Autowired
	private CityService service;

	
	@PostMapping("/Save1")
	public City saveCity(@RequestBody @Valid City city) {
		return service.saveCity(city);
	}
	@GetMapping("/getall")
	 public List<City> getAllCity() {
			return service.getAll();

	}
	@PutMapping("/Update/{id}")
	public City updateCity(@RequestBody @Valid City city ,@PathVariable int id) {
		 return service.updateCity(city, id);
		 
	 }
	@DeleteMapping("/Delete/{id}")
	public String deleteCity(@PathVariable int id) {
		  service.deleteCity(id);
		 return "Sucess";
	 }

}
