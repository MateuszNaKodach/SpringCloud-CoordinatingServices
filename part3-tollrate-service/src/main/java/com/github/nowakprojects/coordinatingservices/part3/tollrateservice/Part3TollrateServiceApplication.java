package com.github.nowakprojects.coordinatingservices.part3.tollrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Part3TollrateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Part3TollrateServiceApplication.class, args);
    }

}
