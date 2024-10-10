package spring_web2.Entity;

import java.util.List;

import spring_web2.Entity.Customer;



public class CustomerPaging {
	private List<Customer> customer;
	
	private long totalCustomer;
	
	private int pageNo;
	
	private int pageSize;

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public long getTotalCustomer() {
		return totalCustomer;
	}

	public void setTotalCustomer(long totalCustomer) {
		this.totalCustomer = totalCustomer;
	}

	public CustomerPaging(List<Customer> customer, long totalCustomer) {
		super();
		this.customer = customer;
		this.totalCustomer = totalCustomer;
	}

	public CustomerPaging(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	

}
