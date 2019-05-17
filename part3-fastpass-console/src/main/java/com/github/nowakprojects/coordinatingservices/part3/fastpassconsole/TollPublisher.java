package com.github.nowakprojects.coordinatingservices.part3.fastpassconsole;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import java.time.Instant;

@EnableBinding(Source.class)
public class TollPublisher {
    private final ObjectMapper objectMapper;

    public TollPublisher(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @InboundChannelAdapter(channel = Source.OUTPUT)
    String sendTollCharge() throws JsonProcessingException {
        var tollCharge =  new TollCharge(
                20,
                100,
                Instant.now()
        );
        return objectMapper.writeValueAsString(tollCharge);
    }

}

class TollCharge {
    private final int station;
    private final int customerid;
    private final Instant timestamp;

    TollCharge(int station, int customerid, Instant timestamp) {
        this.station = station;
        this.customerid = customerid;
        this.timestamp = timestamp;
    }

    public int getStation() {
        return station;
    }

    public int getCustomerid() {
        return customerid;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
