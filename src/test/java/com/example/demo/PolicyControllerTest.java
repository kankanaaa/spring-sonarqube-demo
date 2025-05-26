package com.example.demo;

import com.example.demo.model.Policy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PolicyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllPolicies() throws Exception {
        mockMvc.perform(get("/policies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetPolicyById() throws Exception {
        mockMvc.perform(get("/policies/1001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.policyHolderName").value("Alice"));
    }

    @Test
    public void testAddPolicy() throws Exception {
        Policy policy = new Policy(2001, "TestUser", "Health", 25000,
                LocalDate.now(), LocalDate.now().plusYears(1));
        mockMvc.perform(post("/policies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(policy)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdatePolicy() throws Exception {
        Policy policy = new Policy(1001, "UpdatedUser", "Auto", 19000,
                LocalDate.now(), LocalDate.now().plusYears(1));
        mockMvc.perform(put("/policies/1001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(policy)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePolicy() throws Exception {
        mockMvc.perform(delete("/policies/1001"))
                .andExpect(status().isOk());
    }
}
