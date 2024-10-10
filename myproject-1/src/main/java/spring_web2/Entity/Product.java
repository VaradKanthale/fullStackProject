package spring_web2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	int pid;
	
	@Column(name = "pname")
	@NotEmpty(message = "Not Empty Value")
	String pname;
	
	@Column(name="pPrice")
	int pPrice;
	
	@Column(name="Image")
	String pImage;
	
	@Column(name="status")
	boolean status;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Product(int pid, @NotEmpty(message = "Not Empty Value") String pname, int pPrice, String pImage,
			boolean status) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pPrice = pPrice;
		this.pImage = pImage;
		this.status = status;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pPrice=" + pPrice + ", pImage=" + pImage + ", status="
				+ status + "]";
	}

	
	
}
