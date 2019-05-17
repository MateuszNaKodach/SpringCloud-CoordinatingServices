package com.github.nowakprojects.coordinatingservices.part6.streamtollintake

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@EnableBinding(Sink::class)
@SpringBootApplication
class Part6StreamTollintakeApplication

fun main(args: Array<String>) {
    runApplication<Part6StreamTollintakeApplication>(*args)
}

@Component
class SpringStreamListener {

    @StreamListener(Sink.INPUT)
    fun log(message: String) {
        println(message)
    }
}
