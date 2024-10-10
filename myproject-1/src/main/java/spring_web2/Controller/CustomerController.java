package spring_web2.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.ldap.PagedResultsResponseControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring_web2.Entity.Customer;
import spring_web2.Entity.CustomerPaging;
import spring_web2.Exception.ResourceNotFoundException;
import spring_web2.Repository.CutomerRepository;
import spring_web2.Service.CustomerService;

@RestController
@RequestMapping("/Api")
public class CustomerController {
	
	@Autowired
	private CutomerRepository cus;
	@Autowired
	private CustomerService cservice;
	
	
	   
	@GetMapping("/{pageNo}/{pageSize}")
	public CustomerPaging getAllCustomer(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
		return cservice.getAllPageCustomer(pageNo, pageSize);

}

	@GetMapping("/GetAll")
	public List<Customer> getAllcustomer() {
		return cservice.getAll();

	}

	@PostMapping("/Customer")
	public Customer saveCustomer(@RequestBody @Valid Customer customer) {
		return cus.save(customer);

	}

	@PutMapping("{cid}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer, @PathVariable int cid) {
		Customer result = cus.findById(cid)
			.orElseThrow(() -> new ResourceNotFoundException("Customer Id is Not available: " + cid));

	result.setCname(customer.getCname());
		result.setPassword(customer.getPassword());
		result.setEmail(customer.getEmail());
		result.setCity(customer.getCity());
		result.setStatus(customer.isStatus());

		cus.save(result);

		return ResponseEntity.ok(result);

	}

	@DeleteMapping("{cid}")
	public String deleteCustomer(@PathVariable int cid) {
		Customer result = cus.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Id is Not available: " + cid));
		cus.deleteById(cid);
		return "Record deleted sucessfully";

	}

	@GetMapping("{cid}")
	public Customer getCustomerById(@PathVariable int cid) {

		return cus.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Id is Not available: " + cid));

	}

	@GetMapping("/AllCustomer/Count")
	public long getAllCustomerCount() {

		return cus.getCountAllCustomer();

	}

	@GetMapping("/AllCustomer/Sum")
	public long getWithSumCid() {

		return cus.getWithSumCid();

	}

	@GetMapping("/AllCustomer/Max")
	public List<Object> getWithMaxCid() {

		return cus.getWithMaxCid();

	}

	@GetMapping("/AllCustomer/Avg")
	public Double getWithAvgCid() {

		return cus.getWithAvgCid();

	}

	@GetMapping("/AllCustomer2/Cname")
	public List<Customer> getCustomerByCnameLike() {

		return cus.findCustomerByCnameLike();

	}

	@GetMapping("/AllCustomer2/Cid")
	public List<Customer> getCustomerByCidLessThan(@RequestParam int cid) {

		return cus.findCustomerByCidLessThan(cid);

	}

	@GetMapping("/AllCustomer2/Greater/Cid")
	public List<Customer> findCustomerByCidGreaterThan(@RequestParam int cid) {

		return cus.findCustomerByCidGreaterThan(cid);

	}

	@GetMapping("/AllCustomer2/GreaterEqual/Cid")
	public List<Customer> GetCustomerByCidGreaterThanEqualTo(@RequestParam int cid) {

		return cus.findCustomerByCidGreaterThanEqual(cid);

	}

	@GetMapping("/AllCustomer2/Cid/Cname")
	public List<Customer> GetCustomerByCidAndCname(@RequestParam int cid, @RequestParam String cname) {

		return cus.findCustomerByCidAndCname(cid, cname);

	}

	@GetMapping("/search")
	public ResponseEntity<List<Customer>> searchCustomer(@RequestParam String searchText) {
		List<Customer> searchResults = cservice.searchCustomers(searchText);
		return ResponseEntity.ok(searchResults);
	}

	@GetMapping("/Cname/Asc")
	public List<Customer> findByOrderByCname() {
		return cus.findByOrderByCnameAsc();

	}

	@GetMapping("/cityes/City")
	public List<Customer> findCustomerByCity(@RequestParam String city) {
		return cus.findCustomerByCity(city);

	}

	@GetMapping("/limits/{Limit}")
	public List<Customer> findCustomer(@PathVariable("Limit") int limit) {

		return cservice.findAllCustomer(limit);
	}

	@GetMapping("/id")
	public List<Integer> findCustomer() {

		return cservice.findCustomers();
	}

	@GetMapping("/emails/all/Email")
	public List<Object> findCustomerByEmail(@RequestParam String email) {

		return cus.findCustomerByEmail(email);
	}

	@GetMapping("/GroupByCid")
	public Map<Object, List<String>> getAllCustomersGroupingByCid() {

		return cservice.getAllCustomersGroupingByCid();
	}

}
