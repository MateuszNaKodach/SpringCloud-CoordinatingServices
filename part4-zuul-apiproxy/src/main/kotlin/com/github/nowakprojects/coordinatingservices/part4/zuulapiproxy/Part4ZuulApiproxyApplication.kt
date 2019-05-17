package com.github.nowakprojects.coordinatingservices.part4.zuulapiproxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@SpringBootApplication
class Part4ZuulApiproxyApplication

fun main(args: Array<String>) {
    runApplication<Part4ZuulApiproxyApplication>(*args)
}
