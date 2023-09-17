package com.dnastack.interview.beaconsummarizer.client.beacon;

import lombok.Data;

import java.time.Instant;

@Data
public class Organization {
    private String id;
    private String name;
    private String description;
    private Instant createdDate;
    private String url;
    private String address;
}
