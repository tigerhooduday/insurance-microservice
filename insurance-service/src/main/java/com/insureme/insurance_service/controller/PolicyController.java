package com.insureme.insurance_service.controller;

import com.insureme.insurance_service.entity.Policy;
import com.insureme.insurance_service.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping("/createPolicy")
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.createPolicy(policy));
    }

    @PutMapping("/updatePolicy/{policyId}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long policyId, @RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.updatePolicy(policyId, policy));
    }

    @GetMapping("/viewPolicy/{policyId}")
    public ResponseEntity<Policy> viewPolicy(@PathVariable Long policyId) {
        return ResponseEntity.ok(policyService.viewPolicy(policyId));
    }

    @DeleteMapping("/deletePolicy/{policyId}")
    public ResponseEntity<String> deletePolicy(@PathVariable Long policyId) {
        policyService.deletePolicy(policyId);
        return ResponseEntity.ok("Policy deleted successfully");
    }
}