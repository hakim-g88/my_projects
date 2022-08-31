package com.village.app.testHelpers.fastTouches;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class VillageEndpointTestsFast {
    private RequestSpecification request;

    public VillageEndpointTestsFast(RequestSpecification request) {
        request.contentType("application/json");
        this.request = request;
    }

    public ValidatableResponse create(String testData) {
        return request.
                body(testData).
                post("/village").
                then();
    }

    public ValidatableResponse delete(String id) {
        return request.
                post("/village/" + id).
                then();
    }
}
