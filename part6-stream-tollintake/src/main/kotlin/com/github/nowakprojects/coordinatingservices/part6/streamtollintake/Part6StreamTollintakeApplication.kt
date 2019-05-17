package com.github.nowakprojects.coordinatingservices.part6.streamtollintake

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component

//@EnableBinding(Processor::class)
@EnableBinding(Sink::class)
@SpringBootApplication
class Part6StreamTollintakeApplication

fun main(args: Array<String>) {
    runApplication<Part6StreamTollintakeApplication>(*args)
}


@Component
class SpringStreamListener {

    @StreamListener(Sink.INPUT)
    fun logAll(message: String, @Header("speed") speed: Int) {
        println("log all $speed: $message")
    }

    @StreamListener(Sink.INPUT, condition = "headers['speed'] > 40")
    fun logFast(message: String, @Header("speed") speed: Int) {
        println("log fast $speed: $message")
    }

    @StreamListener(Sink.INPUT, condition = "headers['speed'] <= 40")
    fun logSlow(message: String, @Header("speed") speed: Int) {
        println("log slow $speed: $message")
    }
}


/*
@Component
class SpringStreamListener {

    @ServiceActivator(inputChannel = Sink.INPUT)
    fun log(message: String) {
        println(message)
    }
}*/

/*
@Component
class SpringStreamListener {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    fun log(message: String): String {
        println(message)
        return "Received message $message";
    }
}
*/
