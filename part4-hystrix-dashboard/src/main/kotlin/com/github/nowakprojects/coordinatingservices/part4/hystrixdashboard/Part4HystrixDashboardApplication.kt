package com.github.nowakprojects.coordinatingservices.part4.hystrixdashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard
import org.springframework.cloud.netflix.turbine.EnableTurbine

@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
class Part4HystrixDashboardApplication

fun main(args: Array<String>) {
    runApplication<Part4HystrixDashboardApplication>(*args)
}
