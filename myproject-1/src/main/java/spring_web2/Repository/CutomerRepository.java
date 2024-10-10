package spring_web2.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;import org.springframework.web.bind.annotation.GetMapping;

import spring_web2.Entity.Customer;

@Repository
public interface CutomerRepository extends JpaRepository<Customer, Integer> {

     
      
      
      List<Customer> findByCname(String cname);

  	// long countByCid();

  	@Query(name = "findCountAllCustomer")
  	Long getCountAllCustomer();

  	@Query(name = "findWithSumCid")
  	Long getWithSumCid();

  	@Query(name = "findWithMaxCid")
  	List<Object> getWithMaxCid();

  	@Query(name = "findWithAvgCid")
  	Double getWithAvgCid();

  	@Query(name = "findCustomerByCnameLike")
  	List<Customer> findCustomerByCnameLike();

  	/*
  	 * @Query(value = "select * from Customer where like cname=:name", nativeQuery =
  	 * true) List<Object> findCustomerByCnameLike(@Param("name") String cname);
  	 */

  	// List<Customer> findCustomerByCidLessThan(int cid);

  	List<Customer> findCustomerByCidGreaterThan(int cid);

  	List<Customer> findCustomerByCidGreaterThanEqual(int cid);

  	List<Customer> findCustomerByCidAndCname(int cid, String cname);

  	List<Customer> findCustomerByCidLessThan(int cid);

  	List<Customer> findBycnameContainingIgnoreCase(String searchText);

  	List<Customer> findByOrderByCnameAsc();
  	
  	@Query(value = "select * from Customer where city = City" , nativeQuery = true)
  	List<Customer> findCustomerByCity(String city);  
  	
  	@Query(value ="select cid , cname , city from Customer where email = Email",  nativeQuery = true )
  	   List<Object> findCustomerByEmail(String email);  
  	
  	
      
}
