package com.github.nowakprojects.coordinatingservices.part3.fastpassconsole;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "getFastPassCustomerDetailsBackup")
    @RequestMapping(path = "/customerdetails", params = {"fastpassid"})
    public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {
        FastPassCustomer c = restTemplate.getForObject("http://part3-fastpass-service/fastpass?fastpassid=" + fastpassid, FastPassCustomer.class);
        System.out.println("retrieved customer details with fastpassid: " + fastpassid);
        m.addAttribute("customer", c);
        return "console";
    }

    public String getFastPassCustomerDetailsBackup(@RequestParam String fastpassid, Model m) {
        FastPassCustomer c = new FastPassCustomer();
        c.setFastPassId(fastpassid);
        System.out.println("Fallback operation called for fastpassid: " + fastpassid);
        m.addAttribute("customer", c);
        return "console";
    }

}
