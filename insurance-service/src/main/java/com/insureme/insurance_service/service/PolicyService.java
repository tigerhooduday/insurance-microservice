package com.insureme.insurance_service.service;

import com.insureme.insurance_service.entity.Policy;
import com.insureme.insurance_service.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy updatePolicy(Long policyId, Policy policyDetails) {
        Optional<Policy> policy = policyRepository.findById(policyId);
        if (policy.isPresent()) {
            Policy updatedPolicy = policy.get();
            updatedPolicy.setPolicyHolderName(policyDetails.getPolicyHolderName());
            updatedPolicy.setPolicyType(policyDetails.getPolicyType());
            updatedPolicy.setPremium(policyDetails.getPremium());
            updatedPolicy.setStatus(policyDetails.getStatus());
            return policyRepository.save(updatedPolicy);
        }
        throw new RuntimeException("Policy not found with id " + policyId);
    }

    public Policy viewPolicy(Long policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found with id " + policyId));
    }

    public void deletePolicy(Long policyId) {
        if (policyRepository.existsById(policyId)) {
            policyRepository.deleteById(policyId);
        } else {
            throw new RuntimeException("Policy not found with id " + policyId);
        }
    }
}