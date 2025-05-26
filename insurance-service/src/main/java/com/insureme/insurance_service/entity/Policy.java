package com.insureme.insurance_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Policy {
    @Id
    private Long policyId;
    private String policyHolderName;
    private String policyType; // e.g., Home, Health, Car, Life
    private double premium;
    private String status; // e.g., Active, Expired

    // Default Constructor
    public Policy() {
    }

    // Parameterized Constructor (Optional)
    public Policy(Long policyId, String policyHolderName, String policyType, double premium, String status) {
        this.policyId = policyId;
        this.policyHolderName = policyHolderName;
        this.policyType = policyType;
        this.premium = premium;
        this.status = status;
    }

    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}