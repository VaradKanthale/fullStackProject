package spring_web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_web.Model.City;
import spring_web.Model.Country;
import spring_web.Repository.ConuntryRepository;

@Service
public class CountryService {

	@Autowired
	private ConuntryRepository cr;

	public Country saveCountry(Country country) {
		return cr.save(country);
	}
	 public List<Country> getAll() {
			return cr.findAll();

	}
	 public Country updateCountry(Country country ,int id) {
		 country.setCoid(id);
		 return cr.save(country);
		 
	 }
	 public String deleteCountry(int id) {
		 Country country=cr.getById(id);
		 cr.delete(country);
		return "Sucess";
		 
	 }

}
