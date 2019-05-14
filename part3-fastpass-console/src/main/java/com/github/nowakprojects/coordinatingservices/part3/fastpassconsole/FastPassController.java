package com.github.nowakprojects.coordinatingservices.part3.fastpassconsole;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FastPassController {

	private final RestTemplate restTemplate;

	public FastPassController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping(path="/customerdetails", params={"fastpassid"})
	public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {
		FastPassCustomer c = restTemplate.getForObject("http://part3-fastpass-service/fastpass?fastpassid=" + fastpassid, FastPassCustomer.class);
		System.out.println("retrieved customer details");
		m.addAttribute("customer", c);
		return "console";
	}

}
