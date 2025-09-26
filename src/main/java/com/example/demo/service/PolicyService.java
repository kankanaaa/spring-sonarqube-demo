package com.example.demo.service;

import com.example.demo.model.Policy;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Service
public class PolicyService {

    private final Map<Integer, Policy> policyMap = new HashMap<>();

    @PostConstruct
    public void init() {
        policyMap.put(1001, new Policy(1001, "Alice", "Health", 15000.0, LocalDate.now(), LocalDate.now().plusYears(1)));
        policyMap.put(1002, new Policy(1002, "Bob", "Life", 20000.0, LocalDate.now(), LocalDate.now().plusYears(2)));
    }

    public List<Policy> getAllPolicies() {
        System.out.println("This is a sonar issue");
        return new ArrayList<>(policyMap.values());
    }

    public Policy getPolicyById(int id) {
        return policyMap.get(id);
    }

    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyId(), policy);
    }

    public void updatePolicy(int id, Policy updatedPolicy) {
        policyMap.put(id, updatedPolicy);
    }

    public void deletePolicy(int id) {
        policyMap.remove(id);
    }

    public void clearPolicies() {
        policyMap.clear();
    }
}
