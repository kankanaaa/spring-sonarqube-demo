package com.example.demo;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    @Test
    public void testGetAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        assertTrue(policies.size() >= 2);
    }

    @Test
    public void testGetPolicyById() {
        Policy policy = policyService.getPolicyById(1001);
        assertNotNull(policy);
        assertEquals("Alice", policy.getPolicyHolderName());
    }

    @Test
    public void testAddPolicy() {
        Policy newPolicy = new Policy(2001, "Alice", "Travel", 8000,
                LocalDate.now(), LocalDate.now().plusYears(1));
        policyService.addPolicy(newPolicy);

        Policy retrieved = policyService.getPolicyById(2001);
        assertNotNull(retrieved);
        assertEquals("Alice", retrieved.getPolicyHolderName());
    }

    @Test
    public void testUpdatePolicy() {
        Policy updated = new Policy(1002, "Updated Smith", "Health", 16000,
                LocalDate.now(), LocalDate.now().plusYears(2));
        policyService.updatePolicy(1002, updated);

        Policy retrieved = policyService.getPolicyById(1002);
        assertEquals("Updated Smith", retrieved.getPolicyHolderName());
    }

    @Test
    public void testDeletePolicy() {
        policyService.deletePolicy(1003);
        Policy deleted = policyService.getPolicyById(1003);
        assertNull(deleted);
    }
}
