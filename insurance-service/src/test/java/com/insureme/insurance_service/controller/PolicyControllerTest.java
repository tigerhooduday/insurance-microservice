//////--------- junit test code


// package com.insureme.insurance_service.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.insureme.insurance_service.entity.Policy;
// import com.insureme.insurance_service.service.PolicyService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class PolicyControllerTest {
//     @Autowired
//     private MockMvc mockMvc;

//     @Autowired
//     private PolicyService policyService;

//     private Policy policy;

//     @BeforeMethod
//     public void setUp() {
//         policy = new Policy();
//         policy.setPolicyId(1L);
//         policy.setPolicyHolderName("Test User");
//         policy.setPolicyType("Car");
//         policy.setPremium(1000.00);
//         policy.setStatus("Active");
//         policyService.createPolicy(policy);
//     }

//     @Test
//     public void testCreatePolicy() throws Exception {
//         Policy newPolicy = new Policy();
//         newPolicy.setPolicyId(2L);
//         newPolicy.setPolicyHolderName("New User");
//         newPolicy.setPolicyType("Health");
//         newPolicy.setPremium(1500.00);
//         newPolicy.setStatus("Active");

//         mockMvc.perform(post("/api/createPolicy")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(new ObjectMapper().writeValueAsString(newPolicy)))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.policyId").value(2L))
//                 .andExpect(jsonPath("$.policyHolderName").value("New User"));
//     }

//     @Test
//     public void testViewPolicy() throws Exception {
//         mockMvc.perform(get("/api/viewPolicy/1"))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.policyId").value(1L))
//                 .andExpect(jsonPath("$.policyHolderName").value("Test User"));
//     }
// }




// -----------  TestNG + Spring Boot Runner

package com.insureme.insurance_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insureme.insurance_service.entity.Policy;
import com.insureme.insurance_service.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
public class PolicyControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PolicyService policyService;

    private Policy policy;

    @BeforeMethod
    public void setUp() {
        policy = new Policy();
        policy.setPolicyId(1L);
        policy.setPolicyHolderName("Test User");
        policy.setPolicyType("Car");
        policy.setPremium(1000.00);
        policy.setStatus("Active");
        policyService.createPolicy(policy);
    }

    @Test
    public void testCreatePolicy() throws Exception {
        Policy newPolicy = new Policy();
        newPolicy.setPolicyId(2L);
        newPolicy.setPolicyHolderName("New User");
        newPolicy.setPolicyType("Health");
        newPolicy.setPremium(1500.00);
        newPolicy.setStatus("Active");

        mockMvc.perform(post("/api/createPolicy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newPolicy)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.policyId").value(2L))
                .andExpect(jsonPath("$.policyHolderName").value("New User"));
    }

    @Test
    public void testViewPolicy() throws Exception {
        mockMvc.perform(get("/api/viewPolicy/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.policyId").value(1L))
                .andExpect(jsonPath("$.policyHolderName").value("Test User"));
    }
}
// Note: Ensure that the necessary dependencies for TestNG and Spring Boot are included in your project.
// Also, make sure that the PolicyService and Policy entity are correctly implemented and available in your application context.
