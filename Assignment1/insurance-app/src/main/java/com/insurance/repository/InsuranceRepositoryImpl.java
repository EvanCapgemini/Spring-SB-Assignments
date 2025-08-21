package com.insurance.repository;

import com.insurance.model.PolicyDTO;
import java.util.ArrayList;
import java.util.List;

public class InsuranceRepositoryImpl {
    private List<PolicyDTO> policies = new ArrayList<>();

    public String buyPolicy(PolicyDTO policy) {
        policies.add(policy);
        return "The policy successfully added with policy number: " + policy.getPolicyNumber();
    }

    public List<PolicyDTO> getAllPolicyDetails() {
        return policies;
    }
}
