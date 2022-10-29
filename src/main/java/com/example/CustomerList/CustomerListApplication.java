package com.example.CustomerList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CustomerListApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerListApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(JdbcTemplate jdbcTemplate) {
		return args -> {
			
			jdbcTemplate.execute("INSERT INTO Customer VALUES(1, 'John', 'Smith', 'john.smith@email.com')");
			jdbcTemplate.execute("INSERT INTO Customer VALUES(2, 'Mikko', 'Virtanen', 'mikko.virtanen@sahkoposti.fi')");
			jdbcTemplate.execute("INSERT INTO Customer VALUES(3, 'Anh', 'Nguyen', 'anh.nguyen@mail.com')");
			
		};
	}

}
