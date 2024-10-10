package spring_web2.Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@NamedQuery(name = "findCountAllCustomer", query = "select count(c) from Customer c")
@NamedQuery(name = "findWithSumCid", query = "select sum(c.cid)from Customer c")
@NamedQuery(name="findWithMaxCid", query = "select max(c.cid) ,c.cname from Customer c group by c.cname")
@NamedQuery(name="findWithAvgCid", query = "select avg(c.cid)from Customer c")
@NamedQuery(name="findCustomerByCnameLike", query = "select c from Customer c where c.cname like 'V%' ")
//@NamedQuery(name="findCustomerByCidLessThanAndOrderByDesc", query = "select c from Customer c where c.cid>=3 and order by c.cname desc ")

@Entity
@Table(name = "Customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cid;

	@Column(name = "cname")
	@NotEmpty(message = "Not Empty Value")
	String cname;

	@Column(name = "password")
	// @Pattern( regexp = "(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Size(max = 8, min = 5, message = "maximum length is 8 and minimum length is 5 is password")
	String password;
	
	@Column(name="Email")
	@NotEmpty(message = "Not Empty Value")
	String email;
	
	@Column(name="city")
	@NotEmpty(message = "Not Empty Value")
	String city;

	@Column(name="Status")
     boolean status;

	
	@DateTimeFormat(pattern = "YYYY-DD-MM " )
	@Column(name="Time")
	LocalTime time=LocalTime.now();
	
	@JsonFormat(pattern = "DD-MM-YYYY", shape = Shape.STRING )
	@Column(name="Date")
	 LocalDate dd=LocalDate.now();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Customer_Product", joinColumns = {@JoinColumn  (name = "Customer_ID"
			) },
	inverseJoinColumns = {
			@JoinColumn(name = "Product_ID") })
	List<Product> product = new ArrayList<Product>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDd() {
		return dd;
	}

	public void setDd(LocalDate dd) {
		this.dd = dd;
	}



	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Customer(int cid, @NotEmpty(message = "Not Empty Value") String cname,
			@Size(max = 8, min = 5, message = "maximum length is 8 and minimum length is 5 is password") String password,
			@NotEmpty(message = "Not Empty Value") String email, @NotEmpty(message = "Not Empty Value") String city,
			 boolean status, LocalTime time, LocalDate dd,
			List<Product> product) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.password = password;
		this.email = email;
		this.city = city;
		this.status = status;
		this.time = time;
		this.dd = dd;
		
		this.product = product;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", password=" + password + ", email=" + email + ", city="
				+ city + ", status=" + status + ", time=" + time + ", dd=" + dd + ", product=" + product + "]";
	}

	


}