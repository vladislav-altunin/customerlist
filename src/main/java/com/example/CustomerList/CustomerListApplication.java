package com.example.CustomerList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CustomerList.domain.Customer;
import com.example.CustomerList.domain.CustomerRepo;

@SpringBootApplication
public class CustomerListApplication {
	@Autowired
	private CustomerRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerListApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			repository.save(new Customer("John", "Smith", "john.smith@email.com"));
			repository.save(new Customer("Mikko", "Virtanen", "mikko.virtanen@sahkoposti.fi"));
		};
	}

}
