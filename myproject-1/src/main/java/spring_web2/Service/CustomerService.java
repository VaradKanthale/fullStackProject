package spring_web2.Service;

import java.time.LocalDateTime;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring_web2.Entity.Customer;
import spring_web2.Entity.CustomerPaging;
import spring_web2.Repository.CutomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CutomerRepository cus;

	    
	public List<Customer> getAll() {
		return cus.findAll();

	}

	public Customer saveCustomer(Customer customer) {
		return cus.save(customer);

	}

	public String getDateTime() {
		LocalDateTime dt2 = LocalDateTime.of(2024, 05, 12, 11, 15, 55);
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-mm-yyyy ||");
		DateTimeFormatter isoLocalDate = dtformat.ISO_DATE_TIME;
		return dt2.format(isoLocalDate);

	}

	public List<Customer> searchCustomers(String searchText) {
		return cus.findBycnameContainingIgnoreCase(searchText);
	}

	public CustomerPaging getAllPageCustomer(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Customer> pageResult = cus.findAll(paging);

		CustomerPaging pr = new CustomerPaging(pageNo, pageSize);
		pr.setTotalCustomer(pageResult.getTotalElements());
		System.out.println(">>>>>" + pageResult.getTotalPages());
		if (pageResult.hasContent()) {
			pr.setCustomer(pageResult.getContent());
		} else {
			pr.setCustomer(getAll());
		}
		return pr;
	}

	public List<Customer> findAllCustomer(int limit) {
		return cus.findAll().stream().sorted((o1, o2) -> o1.getCname().compareToIgnoreCase(o2.getCname())).limit(limit)
				.collect(Collectors.toList());

	}

	public List<Integer> findCustomers() {

		return cus.findAll().stream().map(x -> x.getCid()).collect(Collectors.toList());

	}

	public boolean isCustomerExist(int cid) {

		return cus.existsById(cid);

	}

	public Map<Object, List<String>> getAllCustomersGroupingByCid() {
		return cus.findAll().stream().sorted((x, y) -> x.getCid() - y.getCid()).map(x -> x.getCname().toUpperCase())
				.collect(Collectors.groupingBy(x -> x.getClass()));

	}
	

}
