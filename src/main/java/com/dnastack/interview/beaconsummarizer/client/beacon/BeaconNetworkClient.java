package com.dnastack.interview.beaconsummarizer.client.beacon;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

// This client uses Spring's wrapper of the Feign declarative HTTP client library.
// Instructions are at <https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html>

// Documentation for the Beacon REST API is at <https://beacon-network.org/#/developers/api/beacon-network>

/**
 * Beacon Network Client
 *
 * For a quick example how to use this and a sample query, see BeaconClientTest.
 */
public interface BeaconNetworkClient {
    @Headers("Accept: application/json")
    @RequestLine("GET /api/organizations")
    List<Organization> getOrganizations();

    /**
     * Query beacons
     * <p>
     *     The API is described in the "Query beacons" section of <a href="https://beacon-network.org/#/developers/api/beacon-network">Developer Guide</a>.
     * </p>
     * <p>
     *     Please be aware that the backend API uses ZERO-based position, but the frontend uses ONE-based position. To
     *     simply explain the difference, given n as ZERO-based position, the ONE-based position of n is n+1.
     * </p>
     * <p>
     *     The method is originally provided by DNAstack.
     * </p>
     */
    @Headers("Accept: application/json")
    @RequestLine("GET /api/responses?beacon={beacon}&ref={ref}&chrom={chrom}&pos={pos}&allele={allele}&referenceAllele={referenceAllele}")
    List<BeaconResponse> query(@Param("beacon") String beaconId,
                               @Param("ref") String genomeAssemblyId,
                               @Param("chrom") String chromosome,
                               @Param("pos") String zeroBasedPosition,
                               @Param("allele") String alternateAllele,
                               @Param("referenceAllele") String referenceAllele);
}
