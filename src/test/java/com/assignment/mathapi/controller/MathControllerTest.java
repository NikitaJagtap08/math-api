package com.assignment.mathapi.controller;

import com.assignment.mathapi.model.InputRequest;
import com.assignment.mathapi.model.OutputResponse;
import com.assignment.mathapi.model.OutputResponse2;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    public void minTest() throws Exception {

        JsonMapper jsonMapper = new JsonMapper();
        InputRequest inputRequest = jsonMapper.readValue(new File("./src/test/resources/input3.json"), InputRequest.class);
        int value=8;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/math-api/min/"+value)
                .content(jsonMapper.writeValueAsString(inputRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OutputResponse outputResponse = jsonMapper.readValue(mvcResult.getResponse().getContentAsString(), OutputResponse.class);
        Assertions.assertEquals(8,outputResponse.getCount());

    }
    @Test
    public void maxTest() throws Exception {

        JsonMapper jsonMapper = new JsonMapper();
        InputRequest inputRequest = jsonMapper.readValue(new File("./src/test/resources/input3.json"), InputRequest.class);
        int value=8;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/math-api/max/"+value)
                .content(jsonMapper.writeValueAsString(inputRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OutputResponse outputResponse = jsonMapper.readValue(mvcResult.getResponse().getContentAsString(), OutputResponse.class);
        Assertions.assertEquals(2,outputResponse.getCount());

    }
    @Test
    public void averageTest() throws Exception {

        JsonMapper jsonMapper = new JsonMapper();
        InputRequest inputRequest = jsonMapper.readValue(new File("./src/test/resources/input.json"), InputRequest.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/math-api/avg")
                .content(jsonMapper.writeValueAsString(inputRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OutputResponse2 outputResponse2 = jsonMapper.readValue(mvcResult.getResponse().getContentAsString(), OutputResponse2.class);
        Double result = outputResponse2.getResult();
        Assertions.assertEquals("4.6",  String.format("%.1f", result));

    }
   
}
