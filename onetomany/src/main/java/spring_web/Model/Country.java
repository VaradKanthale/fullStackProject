package spring_web.Model;

import java.beans.JavaBean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

	@NamedQuery(name="findCountryGroupByConame", query= "select count(*) , coname from Country group by coname ")
   @NamedQuery(name="findCountryByConameLike", query="select u.coname from Country u where u.coname like'In%'")
 //   @NamedQuery(name="findBookOrderByName", query="select name, id from Book order by name")
@JavaBean
	@Entity
@Table(name = "Country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int coid;
	String coname;

	@OneToOne()
	@JoinColumn(name = "city_id")
	private City city;

	public int getCoid() {
		return coid;
	}

	public void setCoid(int coid) {
		this.coid = coid;
	}

	public String getConame() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country(int coid, String coname, City city) {
		super();
		this.coid = coid;
		this.coname = coname;
		this.city = city;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Country [coid=" + coid + ", coname=" + coname + ", city=" + city + "]";
	}
	

	
}
