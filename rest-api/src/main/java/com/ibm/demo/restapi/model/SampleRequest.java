package com.ibm.demo.restapi.model;

import java.util.List;

public class SampleRequest {
    private String requestId;
    private String emailAddress;
    private List<Object> people;

    public SampleRequest(String requestId, String emailAddress, List<Object> nameList) {
        this.requestId = requestId;
        this.emailAddress = emailAddress;
        this.people = nameList;
    }

    public SampleRequest() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Object> getPeople() {
        return people;
    }

    public void setPeople(List<Object> people) {
        this.people = people;
    }
}
