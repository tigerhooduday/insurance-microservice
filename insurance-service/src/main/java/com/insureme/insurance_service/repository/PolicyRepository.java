package com.insureme.insurance_service.repository;

import com.insureme.insurance_service.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}