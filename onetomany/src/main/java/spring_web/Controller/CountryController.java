package spring_web.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sound.sampled.Line;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring_web.Model.City;
import spring_web.Model.Country;
import spring_web.Repository.ConuntryRepository;
import spring_web.Service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryService service;
	@Autowired
	private ConuntryRepository repo;

	@PostMapping("/SaveCountry")
	public Country saveCountry(@RequestBody @Valid Country country) {
		return service.saveCountry(country);
	}

	@GetMapping
	public List<Country> getAllCountry() {
		return service.getAll();

	}

	@PutMapping("/Update1/{id}")
	public Country updateCountry(@RequestBody @Valid Country country, @PathVariable int id) {
		return service.updateCountry(country, id);

	}

	@DeleteMapping("/Delete1/{id}")
	public String deleteCountry(@PathVariable int id) {
		service.deleteCountry(id);
		return "Sucess";
	}

	/*
	 * @GetMapping("/GetCountry") public List<Country> findNameByLike() { return
	 * repo.findCountryByLike();
	 * 
	 * }
	 */

	@GetMapping("/GetCountryMax")
	public Optional<Country> findWithMaxId() {
		return repo.findWithMaxId();

	}

/*	@GetMapping("/Get/coname/{sort}")
	public List<Country> findNameByLike(@PathVariable String coname,@PathVariable Sort sort) {
		return repo.findByTitleAndSortNative(coname , sort);
	} */
	@GetMapping("/sort")
	public List<Country> findAllCountry(){
		
	org.springframework.data.domain.Sort by = org.springframework.data.domain.Sort.by(Direction.DESC,"coname","city");
		return repo.findAll(by);
		
	}
	/*@GetMapping("/Like")
	public List<Country> findNameByLike(){
		return repo.findNameByLike();
		
	} */
	@GetMapping("/Country/Lessthan")
	public List<Country> findCoidByLessThan(@RequestParam int coid){
		return repo.findByCoidLessThan(coid);
		
	}

	@GetMapping("/Country/coname")
	public List<Country> findByConameLike(@RequestParam String coname){
		return repo.findByConameLike("%"+coname+"%");
		

}

	@GetMapping("/Country/{name}/{id}")
	public List<Country> findCountryByConameAndCoid(@PathVariable("name")String coname , @PathVariable("id")int coid){
		return repo.findCountryByConameAndCoid(coname, coid);
}
/*	@GetMapping("/Country/All")
	public List<Country> findAllCountry1(){
		return repo.findAllCountry();
		
	}*/
	
	/*@GetMapping("/Country/{limit}/{offset}")
	public List<Country> findAllCountry2(@PathVariable("limit")int limit , @PathVariable("offset")int offset){
		return repo.getCountryLimit(limit,offset);
		
	}*/
	/*@GetMapping("/CountryDistinct")
	public List<Country> getContryConame(){
		return repo.findWithDistinctConame();
		
	}*/
	@GetMapping("/Country/Count")
	public Integer findCountryById() {
		return repo.findCountByCountry();
		
	}
	@GetMapping("/Country/Avg")
	public double findCountryById2() {
		return repo.findCountByAvg();
		
	}
	@GetMapping("/Country/Coname")
	public List<Object[]> findCountryGroupByConame() {
		 return repo.findCountryGroupByConame();
		
	}
	@GetMapping("/Country/Coname2")
	public List<String> findCountryByConameLike() {
		 return repo.findCountryByConameLike();
		
	}
}
