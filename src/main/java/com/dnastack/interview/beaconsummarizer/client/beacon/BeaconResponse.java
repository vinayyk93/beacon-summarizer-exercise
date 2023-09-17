package com.dnastack.interview.beaconsummarizer.client.beacon;

import lombok.Data;

import java.util.Map;

/**
 * Beacon Response
 *
 * This is a very minimal/basic mapping to an actual beacon response. Please modify if needed.
 */
@Data
public class BeaconResponse {
    private Beacon beacon;
    private Boolean response;
}
