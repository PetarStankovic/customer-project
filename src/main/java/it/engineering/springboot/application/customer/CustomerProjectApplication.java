package it.engineering.springboot.application.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // menja 3 druge anotacije componentscan configuration i enableautoconfiguration
public class CustomerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProjectApplication.class, args);
	}

}
