package com.github.nowakprojects.coordinatingservices.part2.eurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class Part2EurekaServerApplication

fun main(args: Array<String>) {
    runApplication<Part2EurekaServerApplication>(*args)
}
