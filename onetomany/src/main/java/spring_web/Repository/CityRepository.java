package spring_web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_web.Model.City;



public interface CityRepository extends JpaRepository<City, Integer>{

}
