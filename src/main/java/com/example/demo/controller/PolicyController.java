package com.example.demo.controller;

import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    private String unusedField = "This is unused"; // Sonar issue: unused field

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicy(@PathVariable int id) {
        return policyService.getPolicyById(id);
    }

    @PostMapping
    public void addPolicy(@RequestBody Policy policy) {
        policyService.addPolicy(policy);
    }

    @PutMapping("/{id}")
    public void updatePolicy(@PathVariable int id, @RequestBody Policy policy) {
        policyService.updatePolicy(id, policy);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable int id) {
        policyService.deletePolicy(id);
    }

    // Duplicate method - Sonar issue
    public void duplicateLogic() {
        int a = 10 + 20;
        System.out.println("Sonar issue");
        System.out.println("Duplicate logic = " + a);
    }

    public void duplicateLogic2() {
        int a = 10 + 20;
        System.out.println("Duplicate logic = " + a);
    }
}

