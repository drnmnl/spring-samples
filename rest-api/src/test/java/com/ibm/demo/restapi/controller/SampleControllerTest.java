package com.ibm.demo.restapi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.demo.restapi.model.SampleRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getResponse_ValidInput_ReturnMessage() {
        SampleRequest mockReq = new SampleRequest();
        mockReq.setRequestId("123");
        mockReq.setEmailAddress("darren.elmarc.manuel@ibm.com");
        List<Object> people = new ArrayList<>();
        people.add("{\"name\": \"Darren\"}");
        people.add("{\"name\": \"Elmarc\"}");
        mockReq.setPeople(people);
        String mockReqJson=null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            mockReqJson = objectMapper.writeValueAsString(mockReq);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        try {
            mockMvc.perform(
                    post("/")
                            .content(mockReqJson)
                            .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.status").value("ok"))
                    .andExpect(jsonPath("$.details").value("Processed 2 people for darren.elmarc.manuel@ibm.com"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("OK!!!!");
    }

    @Test
    public void getResponse_InvalidInput_ReturnBadMessage() {
        SampleRequest mockReq = new SampleRequest();
        mockReq.setRequestId("123");
        mockReq.setEmailAddress("darren.elmarc.manuel@ibm.com");
        List<Object> people = null;
        mockReq.setPeople(people);
        String mockReqJson=null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            mockReqJson = objectMapper.writeValueAsString(mockReq);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

        try {
            mockMvc.perform(
                    post("/")
                            .content(mockReqJson)
                            .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.status").value("fail"))
                    .andExpect(jsonPath("$.details").value(""));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}