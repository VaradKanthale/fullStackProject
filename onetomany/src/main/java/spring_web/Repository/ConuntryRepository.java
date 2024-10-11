package spring_web.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring_web.Model.Country;

public interface ConuntryRepository extends JpaRepository<Country, Integer> {

	//@Query(value="select * from Country u where u.coname like '%2' ", nativeQuery=true)
	//List<Country> findCountryByLike();
	
	@Query(value="select u from Country u where u.coid= (select max(u.coid) from Country u) ")
	Optional<Country> findWithMaxId();

 /*	@Query(value="select u from Country u where u.coid= (select distinct(u.coname) from Country u) ")
	List<Country> findWithDistinctConame();*/

/*	@Query(value = "SELECT * FROM Country t WHERE t.coname LIKE '%2' ", nativeQuery = true)
	List<Country> findNameByLike(); */

	List<Country> findByCoidLessThan(int coid);
	
	List<Country> findByConameLike(String coname);
	
	@Query(value="select u from Country u where u.coname=:name and u.coid=:id ")
	List<Country> findCountryByConameAndCoid(@Param("name")String coname , @Param("id")int coid);

/*	@Query(value="SELECT * FROM Country LIMIT 1",nativeQuery = true)
	List<Country> findCountryByLimit(Integer limit);*/
	@Query(value="select count(coid)as count from Country",nativeQuery = true )
	int findCountByCountry();
	
	@Query(value="select avg(coid)as count from Country",nativeQuery = true )
	double findCountByAvg();
	
	@Query(name = "findCountryGroupByConame")
	List<Object[]> findCountryGroupByConame();
	
	@Query(name = "findCountryByConameLike")
	List<String> findCountryByConameLike();
	  

	
	//@Query(value="SELECT * FROM Country u LIMIT 1",nativeQuery = true)
	//List<Country> findAllCountry();

	//List<Country> getCountryLimit(int limit, int offset);

}
