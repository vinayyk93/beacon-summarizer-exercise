package com.dnastack.interview.beaconsummarizer;

import com.dnastack.interview.beaconsummarizer.client.beacon.BeaconNetworkClient;
import com.dnastack.interview.beaconsummarizer.client.beacon.Organization;
import com.dnastack.interview.beaconsummarizer.model.BeaconSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.stream.Collectors.toList;

@RestController
public class BeaconSummaryController {
    private static ExecutorService networkExecutorService = Executors.newFixedThreadPool(10);

    @Autowired
    private BeaconNetworkClient beaconClient;

    @GetMapping("/search")
    public BeaconSummary search(@RequestParam String ref,
                                @RequestParam String chrom,
                                @RequestParam String pos,
                                @RequestParam String allele,
                                @RequestParam String referenceAllele) {

        List<String> orgNames = beaconClient.getOrganizations()
                .stream()
                .map(Organization::getName)
                .collect(toList());

        return new BeaconSummary(orgNames);
    }
}

