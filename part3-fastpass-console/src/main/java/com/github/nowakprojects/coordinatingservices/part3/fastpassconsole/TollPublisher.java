package com.github.nowakprojects.coordinatingservices.part3.fastpassconsole;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

import java.time.Instant;
import java.util.Random;

@EnableBinding(TollSource.class)
public class TollPublisher {
    private final ObjectMapper objectMapper;
    private final Random random = new Random();

    public TollPublisher(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    //@InboundChannelAdapter(channel = TollSource.FASTPASS_TOLL, poller = @Poller(fixedDelay = "2000"))
    MessageSource<TollCharge> sendTollCharge() {
        var tollCharge = new TollCharge(
                20,
                100,
                Instant.now()
        );
        return () -> MessageBuilder.withPayload(tollCharge)
                .setHeader("speed", random.nextInt(8) * 10)
                .build();
    }

}

class TollCharge {
    private final String stationId;
    private final String customerId;
    private final String timestamp;

    public TollCharge(int stationId, int customerId, Instant timestamp) {
        this.stationId = String.valueOf(stationId);
        this.customerId = String.valueOf(customerId);
        this.timestamp = timestamp.toString();
    }

    public String getStationId() {
        return stationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "TollCharge{" +
                "stationId='" + stationId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
