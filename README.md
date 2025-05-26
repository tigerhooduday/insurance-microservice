
# Insurance Microservice

This is a Spring Boot-based microservice for Insure-Me, a global insurance provider. The project demonstrates a transition from a monolithic to a microservice architecture, implementing a CI/CD pipeline using Git, Jenkins, Docker, Ansible, and AWS. The microservice manages insurance policies using an in-memory H2 database and exposes REST APIs for policy management.

## Table of Contents
- [Project Overview](#project概view)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [CI/CD Pipeline](#cicd-pipeline)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
Insure-Me is a global insurance provider offering products like Home, Health, Car, and Life Insurance. This project implements a proof-of-concept (POC) microservice to manage insurance policies, addressing challenges like complex builds, manual testing, and slow deployments. The microservice uses Spring Boot with an H2 database and is deployed via a CI/CD pipeline using Jenkins, Docker, Ansible, and AWS EC2.

## Features
- Create, update, view, and delete insurance policies via REST APIs.
- In-memory H2 database with preloaded policy data.
- Unit testing with JUnit/TestNG and HTML report generation.
- Automated CI/CD pipeline with Jenkins for building, testing, and deploying.
- Containerized deployment using Docker.
- Infrastructure configuration using Ansible.
- Automated testing of deployed application using Selenium.
- Deployment to AWS EC2 for test and production environments.

## Technologies Used
- **Java 17**: Programming language.
- **Spring Boot**: Framework for building the microservice.
- **H2 Database**: In-memory database for storing policy data.
- **Maven**: Build tool.
- **JUnit/TestNG**: Testing frameworks.
- **Git**: Version control.
- **Jenkins**: CI/CD automation server.
- **Docker**: Containerization.
- **Ansible**: Infrastructure configuration.
- **Selenium**: Automated testing of deployed application.
- **AWS EC2**: Cloud hosting for deployment.

## Prerequisites
- Java 17 JDK
- Maven 3.8+
- Git
- Docker
- Ansible
- Python (for Selenium)
- AWS CLI and an AWS account
- VS Code (or any IDE)
- Jenkins server (running locally or on AWS EC2)

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd insurance-service

    Install Dependencies:
        Ensure Java 17 and Maven are installed.
        Run:
        bash

        mvn clean install

    Configure Application:
        The H2 database is configured in src/main/resources/application.properties:
        properties

        spring.datasource.url=jdbc:h2:mem:insureme
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.username=sa
        spring.datasource.password=
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        spring.h2.console.enabled=true
        spring.jpa.hibernate.ddl-auto=update

        Preloaded data is in src/main/resources/data.sql.
    Run the Application:
    bash

    mvn spring-boot:run

        Access the H2 console at http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:insureme, Username: sa, Password: blank).

API Endpoints
The microservice exposes the following REST APIs:
Method
    
Endpoint
    
Description
    
Request Body Example
POST
    
/api/createPolicy
    
Create a new policy
    
{"policyId": 4, "policyHolderName": "Alice Brown", "policyType": "Life", "premium": 1800.00, "status": "Active"}
PUT
    
/api/updatePolicy/{policyId}
    
Update an existing policy
    
{"policyHolderName": "John Doe Updated", "policyType": "Car", "premium": 1300.00, "status": "Active"}
GET
    
/api/viewPolicy/{policyId}
    
View a policy by ID
    
None
DELETE
    
/api/deletePolicy/{policyId}
    
Delete a policy by ID
    
None

    Base URL: http://localhost:8080 (local) or http://<ec2-public-ip>:8083 (deployed).
    Test APIs using Postman or curl.

Testing

    Unit Tests:
        Tests are in src/test/java/com/insureme/insurance_service/controller/PolicyControllerTest.java.
        Run tests:
        bash

        mvn test

    TestNG HTML Report:
        Configured in src/test/resources/testng.xml.
        Generate report:
        bash

        mvn clean test

        View report at target/surefire-reports/index.html.
    Selenium Tests:
        Automated UI tests are in tests/selenium_test.py.
        Run:
        bash

        python3 tests/selenium_test.py

CI/CD Pipeline
The project includes a Jenkins pipeline for continuous integration and deployment:

    Trigger: GitHub webhook on push to main branch.
    Stages:
        Checkout: Pulls code from GitHub.
        Build: Compiles and packages using Maven.
        Test: Runs TestNG tests and generates HTML reports.
        Build Docker Image: Creates a Docker image (insurance-service:v<build-number>).
        Push Docker Image: Pushes to Docker Hub.
        Configure Server: Uses Ansible to set up the test server.
        Deploy to Test: Deploys to AWS EC2 test server (port 8083).
        Selenium Test: Runs automated UI tests.
        Deploy to Prod: Deploys to AWS EC2 prod server (port 8084).
    Jenkinsfile: Located in the project root (Jenkinsfile).
    Ansible Playbook: Located in ansible/playbook.yml.

Deployment

    AWS EC2 Setup:
        Two EC2 instances: Jenkins-Server and Test-Prod-Server.
        Install Java, Docker, and Jenkins on Jenkins-Server.
        Install Java and Docker on Test-Prod-Server.
    Docker Deployment:
        Test environment: http://<ec2-public-ip>:8083.
        Prod environment: http://<ec2-public-ip>:8084.
    Ansible Configuration:
        Run ansible-playbook -i ansible/inventory.ini ansible/playbook.yml to configure the test-prod server.

Contributing

    Fork the repository.
    Create a feature branch: git checkout -b feature/your-feature.
    Commit changes: git commit -m "Add your feature".
    Push to the branch: git push origin feature/your-feature.
    Open a pull request.

License
This project is licensed under the MIT License.


### **Steps to Add to GitHub**
1. **Create `README.md`**:
   - In VS Code, navigate to `insurance-service` (the root of the Spring Boot module).
   - Right-click, select **New File**, and name it `README.md`.
   - Copy and paste the above content into `README.md`.
   - Save the file.

2. **Commit and Push**:
   - In the `insurance-service` directory, run:
     ```bash
     git add README.md
     git commit -m "Add README for insurance microservice"
     git push origin main
     ```

3. **Verify on GitHub**:
   - Visit your GitHub repository in a browser.
   - The `README.md` content should display on the main page.

### **Notes**
- **Repository URL**: Replace `<repository-url>` in the `git clone` command with your actual GitHub repository URL (e.g., `https://github.com/your-username/insurance-microservice.git`) when setting up the project.
- **Docker Image**: Update `insurance-service:v<build-number>` in the CI/CD section with your Docker Hub username (e.g., `your-dockerhub-username/insurance-service:v<build-number>`) if needed.
- **Preview in VS Code**: Install the **Markdown Preview Enhanced** extension, right-click `README.md`, and select **Markdown: Open Preview** to check formatting.
- **Validation**: Compare with the StarAgile repository’s `README.md` (`https://github.com/StarAgileDevOpsTraining/star-agile-insurance-project.git`) for any missing details, such as specific API formats.

If you face issues (e.g., Git push errors, formatting problems), let me know the error messages, and I’ll help troubleshoot. You’re doing awesome!