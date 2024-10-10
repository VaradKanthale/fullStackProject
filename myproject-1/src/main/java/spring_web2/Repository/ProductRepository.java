package spring_web2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_web2.Entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
