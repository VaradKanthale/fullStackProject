package spring_web2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import spring_web2.Entity.Product;
import spring_web2.Exception.ResourceNotFoundException;
import spring_web2.Repository.ProductRepository;
import spring_web2.Service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Api2")
public class ProductController {

	@Autowired
	private ProductRepository prs;
	@Autowired
	private ProductService pservice;

	@GetMapping
	public List<Product> getAllproduct() {
		return prs.findAll();

	}

	@PostMapping
	public Product saveProduct(@RequestBody @Valid Product product) {
		return pservice.saveProduct(product);

	}
	@PutMapping("{pid}")
	public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product, @PathVariable int pid){
Product product2=prs.findById(pid).orElseThrow(()-> new ResourceNotFoundException("Product id is not found"+pid));	
		
product2.setPname(product.getPname());
product2.setpPrice(product.getpPrice());
product2.setpImage(product.getpImage());
product2.setStatus(product.isStatus()); 



prs.save(product2);
		
		return ResponseEntity.ok(product2);
		
	}
	@DeleteMapping("{pid}")
	public String deleteProduct(@PathVariable int pid) {
Product result =prs.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product Id is Not available: " + pid));
		prs.deleteById(pid);
return "Delete Sucessfully";
		
	}

}
