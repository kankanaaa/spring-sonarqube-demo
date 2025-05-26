🛡️ Insurance CRUD Policy Management App
==========================================
This is a simple Spring Boot-based Insurance Policy CRUD application. It uses static in-memory data (no database) and supports basic operations such as:

Get all policies

Get policy by ID

Add a new policy

Update an existing policy

Delete a policy

🚀 Tech Stack
=================
Java 17

Spring Boot

Maven

Swagger UI

JUnit 5

JaCoCo (for code coverage)

SonarQube (for static code analysis)

GitHub Actions (CI/CD)

📚 API Documentation (Swagger)
=================================
After starting the application, these help you explore and test all REST endpoints in the application:

Swagger UI is available at: http://localhost:8080/swagger-ui/index.html

OpenAPI docs are available at: http://localhost:8080/v3/api-docs

🔒 SonarQube Integration via GitHub Actions
==============================================
This project is integrated with SonarQube using GitHub Actions. What’s enforced:

Static code analysis via Sonar

Code coverage via JaCoCo

Pull Request (PR) builds will fail if there are new Sonar issues or test coverage drops below threshold

This ensures that all new code contributions meet quality standards before merging.The coverage and analysis report is auto-uploaded on each push or PR to SonarQube.
