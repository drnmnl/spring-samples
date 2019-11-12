package com.ibm.demo.restapi.controller;

import com.ibm.demo.restapi.model.SampleRequest;
import com.ibm.demo.restapi.model.SampleResponse;
import com.ibm.demo.restapi.service.ValidatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private ValidatorService validatorService = new ValidatorService();

    @PostMapping("/")
    public ResponseEntity<SampleResponse> getResponse(@RequestBody SampleRequest requestBody) {
        boolean inputValid = validatorService.isInputValid(requestBody);
        SampleResponse response = new SampleResponse();
        if (inputValid) {
            int x = requestBody.getPeople().size();
            String y = requestBody.getEmailAddress();
            response.setStatus("ok");
            StringBuilder sb = new StringBuilder();
            sb.append("Processed ").append(x).append(" people for ").append(y);
            response.setDetails(sb.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatus("fail");
            response.setDetails("");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
