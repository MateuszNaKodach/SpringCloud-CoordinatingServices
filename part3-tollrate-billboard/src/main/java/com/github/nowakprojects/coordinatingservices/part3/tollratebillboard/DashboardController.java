package com.github.nowakprojects.coordinatingservices.part3.tollratebillboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class DashboardController {

    private final RestTemplate restTemplate;

    public DashboardController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getTollRateBackup")
    @RequestMapping("/dashboard")
    public String getTollRate(@RequestParam int stationId, Model m) {
        TollRate tr = restTemplate.getForObject("http://part3-toll-service/tollrate/" + stationId, TollRate.class);
        System.out.println("stationId: " + stationId);
        m.addAttribute("rate", tr.getCurrentRate());
        return "dashboard";
    }

    public String getTollRateBackup(@RequestParam int stationId, Model m) {
        System.out.println("Fallback operation called for statiodId: " + stationId);
        m.addAttribute("rate", "1.00");
        return "dashboard";
    }
}
