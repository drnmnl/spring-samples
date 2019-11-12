package com.ibm.demo.restapi.service;

import com.ibm.demo.restapi.model.SampleRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class ValidatorServiceTest {

    @Test
    public void testIsInputValid() {
        SampleRequest mockReq = new SampleRequest();
        mockReq.setRequestId("123");
        mockReq.setEmailAddress("darren.elmarc.manuel@ibm.com");
        List<Object> people = new ArrayList<>();
        people.add("{\"name\": \"Darren\"}");
        people.add("{\"name\": \"Elmarc\"}");
        mockReq.setPeople(people);

        assertNotEquals("", mockReq.getRequestId());
        assertNotEquals("", mockReq.getEmailAddress());
        assertNotNull(mockReq.getPeople());
        assertFalse(mockReq.getPeople().isEmpty());
    }

}