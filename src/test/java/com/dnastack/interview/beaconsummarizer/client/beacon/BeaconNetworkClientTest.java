package com.dnastack.interview.beaconsummarizer.client.beacon;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class BeaconNetworkClientTest {
    @Test
    public void doNotModifyThisTest() {
        final BeaconNetworkClient client = Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BeaconNetworkClient.class, "https://beacon-network.org/");

        // This is based on the sample query from the UI, which is "GRCh37: 13: 32936731 G > C".
        final List<BeaconResponse> responses = client.query(
                "brca-exchange",
                "GRCh37",
                "13",
                "32936731",
                "C",
                "G"
        );

        assertThat(responses.size(), equalTo(1));
        responses.forEach(
                beaconResponse -> assertThat(
                        String.format("B/%s: response should be true, but it is %s", beaconResponse.getBeacon(), beaconResponse.getResponse()),
                        beaconResponse.getResponse(),
                        equalTo(true))
        );
    }
}
