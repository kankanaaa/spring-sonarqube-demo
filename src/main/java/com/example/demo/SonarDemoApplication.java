package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the SonarQube Demo Spring Boot application.
 */
@SpringBootApplication
public class SonarDemoApplication {

    /**
     * Main method to start the Spring Boot application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(SonarDemoApplication.class, args);
        // INTENTIONAL SONAR ISSUE: System.out.println should not be used in production code (S106).
        // Use a logger instead.
        System.out.println("Sonar Demo REST API Application Started Successfully!");
    }

    /**
     * INTENTIONAL SONAR ISSUE: This public method is unused (S1144).
     * Unused methods should be removed to keep the codebase clean.
     */
    public void anUnusedPublicMethod() {
        // INTENTIONAL SONAR ISSUE: This local variable is declared but not used (S1481).
        String unusedLocalVariable = "This value is never read.";

        // INTENTIONAL SONAR ISSUE: "Magic numbers" should be replaced by named constants (S109).
        // For example, '5' here is a magic number.
        int magicNumber = 5;
        if (magicNumber > 3) {
            // INTENTIONAL SONAR ISSUE: System.out.println (S106).
            System.out.println("Magic number is greater than 3.");
        }
    }

    /**
     * INTENTIONAL SONAR ISSUE: Method names should comply with a naming convention (e.g., camelCase) (S00100).
     * This method name 'AVeryBadlyNamed_Method' violates standard Java naming conventions.
     */
    public void AVeryBadlyNamed_Method() {
        // This method's name is intentionally non-compliant for demonstration.
        // INTENTIONAL SONAR ISSUE: System.out.println (S106).
        System.out.println("Executing a badly named method.");
    }
}
