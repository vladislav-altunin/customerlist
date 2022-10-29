package com.example.CustomerList.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CustomerList.domain.Customer;

@Controller
public class CustomerController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/customerlist")
	public String getCustomerList(Model model) {

	        String sql = "SELECT * FROM CUSTOMER";

	        List<Customer> customers = jdbcTemplate.query(
	                sql,
	                (rs, rowNum) ->
	                        new Customer(
	                                rs.getString("firstName"),
	                                rs.getString("lastName"),
	                                rs.getString("email")
	                        )
	        );
		
		model.addAttribute("customers", customers);
		return "customerlist";
	}
}
