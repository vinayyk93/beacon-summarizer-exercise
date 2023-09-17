package com.dnastack.interview.beaconsummarizer.client.beacon;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeaconNetworkClientConfiguration {
    @Bean
    public BeaconNetworkClient beaconNetworkClient(ObjectMapper objectMapper) {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.BASIC)
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(BeaconNetworkClient.class, "https://beacon-network.org/");
    }
}
