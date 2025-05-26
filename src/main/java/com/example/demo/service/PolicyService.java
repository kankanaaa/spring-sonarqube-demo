package com.example.demo.service;

import com.example.demo.model.Policy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PolicyService {

    private static final Map<Integer, Policy> POLICY_MAP = new HashMap<>();

    static {
        POLICY_MAP.put(1001, new Policy(1001, "Alice", "Health", 15000.0, LocalDate.now(), LocalDate.now().plusYears(1)));
        POLICY_MAP.put(1002, new Policy(1002, "Bob", "Life", 20000.0, LocalDate.now(), LocalDate.now().plusYears(2)));
    }

    public List<Policy> getAllPolicies() {
        return new ArrayList<>(POLICY_MAP.values());
    }

    public Policy getPolicyById(int id) {
        return POLICY_MAP.get(id);
    }

    public void addPolicy(Policy policy) {
        POLICY_MAP.put(policy.getPolicyId(), policy);
    }

    public void updatePolicy(int id, Policy updatedPolicy) {
        POLICY_MAP.put(id, updatedPolicy);
    }

    public void deletePolicy(int id) {
        POLICY_MAP.remove(id);
    }
}
