package com.github.nowakprojects.coordinatingservices.part3.fastpassservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Part3FastpassServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Part3FastpassServiceApplication.class, args);
    }

}
