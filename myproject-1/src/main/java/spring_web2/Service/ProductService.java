package spring_web2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_web2.Entity.Customer;
import spring_web2.Entity.Product;
import spring_web2.Repository.CutomerRepository;
import spring_web2.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prs;
	
	public List<Product> getAll(){
		return prs.findAll();
		
	}
	
	public Product saveProduct(Product product){
		return prs.save(product);
		
	}

}
