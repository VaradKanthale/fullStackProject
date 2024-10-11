package spring_web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Appconfig {


@Bean
public void destroy() {
	System.out.println("Spring boot Shut Down Application");
}

}
