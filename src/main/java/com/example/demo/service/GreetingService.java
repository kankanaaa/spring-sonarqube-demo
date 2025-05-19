package com.example.demo.service;

import com.example.demo.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting(String name) {
        try {
            String processed = StringUtil.capitalize(name);
            String secret = "hardcodedSecretValue"; // Hardcoded secret
            // System.out.println("Secret: " + secret); // Commented out code
            return "Hello, " + processed;
        } catch (Exception e) {
            e.printStackTrace(); // Poor exception handling
            return "Oops!";
        }
    }
}
