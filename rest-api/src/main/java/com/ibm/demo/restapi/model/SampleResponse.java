package com.ibm.demo.restapi.model;

public class SampleResponse {
    private String status;
    private String details;

    public SampleResponse(String status, String details) {
        this.status = status;
        this.details = details;
    }

    public SampleResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
