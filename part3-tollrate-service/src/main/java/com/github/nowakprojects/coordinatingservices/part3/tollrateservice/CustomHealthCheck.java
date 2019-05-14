package com.github.nowakprojects.coordinatingservices.part3.tollrateservice;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    int errorCode = 0;

    @Override
    public Health health() {
        System.out.println("health check performed, error code is " + errorCode);

        errorCode++;
        if (errorCode > 4 && errorCode < 8) {
            return Health.down()
                    .withDetail("Custom Error Code", errorCode)
                    .build();
        }
        return Health.up().build();
    }
}
