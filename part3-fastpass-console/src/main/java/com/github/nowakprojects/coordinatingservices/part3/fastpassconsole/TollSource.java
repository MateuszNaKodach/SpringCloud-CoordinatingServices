package com.github.nowakprojects.coordinatingservices.part3.fastpassconsole;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TollSource {

    static final String FASTPASS_TOLL = "fastpassToll";
    static final String STANDARD_TOLL = "standardToll";

    @Output
    MessageChannel fastpassToll();

    @Output
    MessageChannel standardToll();

}
