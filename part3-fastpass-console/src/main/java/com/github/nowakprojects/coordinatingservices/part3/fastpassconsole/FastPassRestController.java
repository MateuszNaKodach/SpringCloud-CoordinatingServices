package com.github.nowakprojects.coordinatingservices.part3.fastpassconsole;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
class FastPassRestController {

    private final TollSource tollSource;

    public FastPassRestController(TollSource tollSource) {
        this.tollSource = tollSource;
    }

    @PostMapping("/toll")
    String publishMessage(@RequestBody String payload) {
        System.out.println(payload);
        Random r = new Random();
        tollSource.fastpassToll().send(
                MessageBuilder.withPayload(payload)
                        .setHeader("speed", r.nextInt(8) * 10)
                        .build()
        );
        return "success";
    }
}
