package spring_web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_web.Model.City;
import spring_web.Model.Country;
import spring_web.Repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cr;

	public City saveCity(City city) {
		return cr.save(city);
	}
		
     public List<City> getAll() {
			return cr.findAll();

	}
     public City updateCity(City city ,int id) {
		 city.setCid(id);
		 return cr.save(city);
		 
	 }
     
     public String deleteCity(int id) {
		City city= cr.getById(id);
		 cr.delete(city);
		return "Sucess";
		 
	 }

}
