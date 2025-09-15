package com.example.demo.service;

import com.example.demo.model.Policy;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Service
public class PolicyService {

    // SONAR ISSUE (Code Smell): Fields in a "@Service" should be private.
    // SONAR ISSUE (Code Smell): Static fields should be "final".
    public static String companyName = "MegaCorp Insurance";

    private final Map<Integer, Policy> policyMap = new HashMap<>();

    @PostConstruct
    public void init() {
        policyMap.put(1001, new Policy(1001, "Alice", "Health", 15000.0, LocalDate.now(), LocalDate.now().plusYears(1)));
        policyMap.put(1002, new Policy(1002, "Bob", "Life", 20000.0, LocalDate.now(), LocalDate.now().plusYears(2)));
    }

    public List<Policy> getAllPolicies() {
        return new ArrayList<>(policyMap.values());
    }

    /**
     * This method can throw a NullPointerException.
     */
    public Policy getPolicyById(int id) {
        // SONAR ISSUE (Bug): A "NullPointerException" could be thrown; the result of "policyMap.get(id)" should be checked for null.
        System.out.println("Fetching policy holder: " + policyMap.get(id).getPolicyHolderName()); // This line will crash if id is not found.

        // SONAR ISSUE (Code Smell): Using System.out or System.err is discouraged. Use a logger instead.
        System.out.println("Operation complete for ID: " + id);

        return policyMap.get(id);
    }

    public void addPolicy(Policy policy) {
        // This whole block is duplicated in updatePolicy
        // SONAR ISSUE (Code Smell): This block of code is duplicated in the "updatePolicy" method.
        if (policy.getPolicyHolderName() == "Default") { // SONAR ISSUE (Bug): Strings should be compared with ".equals()", not "==".
            System.out.println("Cannot add policy for default user.");
            return;
        }
        policyMap.put(policy.getPolicyId(), policy);
    }

    public void updatePolicy(int id, Policy updatedPolicy) {
        // SONAR ISSUE (Code Smell): The parameter "id" is unused. The method uses the ID from the policy object instead.
        // This whole block is duplicated from addPolicy
        // SONAR ISSUE (Code Smell): This block of code is duplicated from the "addPolicy" method.
        if (updatedPolicy.getPolicyHolderName() == "Default") { // SONAR ISSUE (Bug): Strings should be compared with ".equals()", not "==".
            System.out.println("Cannot update policy for default user.");
            return;
        }
        policyMap.put(updatedPolicy.getPolicyId(), updatedPolicy);
    }

    public void deletePolicy(int id) {
        try {
            policyMap.remove(id);
        } catch (Exception e) {
            // SONAR ISSUE (Code Smell): Catching the generic "Exception" is discouraged.
            // SONAR ISSUE (Code Smell): The caught exception "e" is ignored. At least log it.
        }
    }

    // SONAR ISSUE (Code Smell): This method has a high Cognitive Complexity. It's hard to understand.
    public List<Policy> findPolicies(String name, String type) {
        List<Policy> results = new ArrayList<>();
        for (Integer key : policyMap.keySet()) {
            if (key != null) {
                Policy p = policyMap.get(key);
                if (p != null) {
                    if (p.getPolicyHolderName().equals(name)) {
                        if (p.getPolicyType().equals(type)) {
                            results.add(p);
                        }
                    }
                }
            }
        }
        return results;
    }

    // SONAR ISSUE (Vulnerability): Hardcoded credentials are a security risk.
    private void performAdminAction() {
        String password = "admin_password_1234"; // Bad practice!

        if ("admin_password_1234".equals(password)) {
            // Do something critical
        }
    }

  
    public void clearPolicies() {
        policyMap.clear();
    }
    
}