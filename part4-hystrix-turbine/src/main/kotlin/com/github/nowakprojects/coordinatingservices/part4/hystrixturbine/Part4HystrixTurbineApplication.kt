package com.github.nowakprojects.coordinatingservices.part4.hystrixturbine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream

@EnableTurbineStream
@SpringBootApplication
class Part4HystrixTurbineApplication

fun main(args: Array<String>) {
    runApplication<Part4HystrixTurbineApplication>(*args)
}
