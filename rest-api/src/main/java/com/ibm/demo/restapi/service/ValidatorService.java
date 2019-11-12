package com.ibm.demo.restapi.service;
import com.ibm.demo.restapi.model.SampleRequest;

public class ValidatorService {
    public boolean isInputValid(SampleRequest request) {
        if (request.getEmailAddress().isEmpty() || request.getRequestId().isEmpty() ||
                request.getPeople()==null || request.getPeople().isEmpty()) {
            return false;
        } else
            return true;
    }
}
