package com.example.demo;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() {
        policyService.clearPolicies();
        policyService.addPolicy(new Policy(1001, "Alice", "Health", 15000.0, LocalDate.now(), LocalDate.now().plusYears(1)));
        policyService.addPolicy(new Policy(1002, "Bob", "Life", 20000.0, LocalDate.now(), LocalDate.now().plusYears(2)));
    }

    @Test
    public void testGetAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        assertNotNull(policies);
        assertEquals(2, policies.size());
    }

    @Test
    public void testGetPolicyById() {
        Policy policy = policyService.getPolicyById(1001);
        assertNotNull(policy);
        assertEquals("Alice", policy.getPolicyHolderName());
    }

    @Test
    public void testAddPolicy() {
        Policy newPolicy = new Policy(3001, "Charlie", "Auto", 18000, LocalDate.now(), LocalDate.now().plusYears(1));
        policyService.addPolicy(newPolicy);

        Policy retrieved = policyService.getPolicyById(3001);
        assertNotNull(retrieved);
        assertEquals("Charlie", retrieved.getPolicyHolderName());
    }

    @Test
    public void testUpdatePolicy() {
        Policy updated = new Policy(1002, "Updated Bob", "Life", 25000, LocalDate.now(), LocalDate.now().plusYears(3));
        policyService.updatePolicy(1002, updated);

        Policy retrieved = policyService.getPolicyById(1002);
        assertEquals("Updated Bob", retrieved.getPolicyHolderName());
        assertEquals(25000, retrieved.getPremiumAmount());
    }

    @Test
    public void testDeletePolicy() {
        policyService.deletePolicy(1001);
        Policy deleted = policyService.getPolicyById(1001);
        assertNull(deleted);
    }
    
    @Test
    public void testPolicy() {
    	Policy policy = new Policy(1002, "Updated Mary", "Health", 7000, LocalDate.now(), LocalDate.now().plusYears(3));

    }
}
