package spring_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_web.Model.Country;

@SpringBootApplication
public class OnetomanyApplication {
@json
	public static void main(String[] args) {
		ConfigurableApplicationContext spring=SpringApplication.run(OnetomanyApplication.class, args);
		System.out.println("done");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_web/been.xml");
		
		Country country=applicationContext.getBean(Country.class);
		System.out.println(country.getConame());
		
		ClassPathXmlApplicationContext ca= (ClassPathXmlApplicationContext) applicationContext;
      ca.close();
	}

}
