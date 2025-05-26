package com.example.demo.service;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PolicyServiceTest {

    private final PolicyService policyService = new PolicyService();

    @Test
    public void testGetAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        assertFalse(policies.isEmpty());
    }

    @Test
    public void testAddPolicy() {
        Policy policy = new Policy(1003, "Charlie", "Motor", 12000, LocalDate.now(), LocalDate.now().plusYears(1));
        policyService.addPolicy(policy);
        assertEquals("Charlie", policyService.getPolicyById(1003).getPolicyHolderName());
    }

    @Test
    public void testDeletePolicy() {
        policyService.deletePolicy(1001);
        assertNull(policyService.getPolicyById(1001));
    }
}

