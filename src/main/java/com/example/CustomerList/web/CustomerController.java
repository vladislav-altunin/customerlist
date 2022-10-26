package com.example.CustomerList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CustomerList.domain.CustomerRepo;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepo custrepo;
	
	@GetMapping("/customerlist")
	public String getCustomerList(Model model) {
		model.addAttribute("customers", custrepo.findAll());
		return "customerlist";
	}
}
