package com.insurance.service;

import com.insurance.model.*;
import com.insurance.repository.InsuranceRepositoryImpl;
import com.insurance.validator.Validator;
import com.insurance.exception.InsuranceException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class InsuranceServiceImpl {
    private InsuranceRepositoryImpl insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepositoryImpl repo) {
        this.insuranceRepository = repo;
    }

    public String buyPolicy(PolicyDTO policy) throws InsuranceException {
        Validator.validate(policy);
        return insuranceRepository.buyPolicy(policy);
    }

    public double calculateAge(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).toTotalMonths();
    }

    public List<PolicyReportDTO> getReport(String policyType) throws InsuranceException {
        List<PolicyDTO> allPolicies = insuranceRepository.getAllPolicyDetails();
        List<PolicyDTO> filtered = allPolicies.stream()
            .filter(p -> p.getPolicyType().equals(policyType))
            .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            throw new InsuranceException("Service.NO_RECORD");
        }

        return filtered.stream().map(p -> {
            PolicyReportDTO report = new PolicyReportDTO();
            report.setPolicyNumber(p.getPolicyNumber());
            report.setPolicyHolderName(p.getPolicyHolderName());
            report.setTenureInMonths(p.getTenureInMonths());
            report.setPolicyHolderAge(calculateAge(p.getDateOfBirth()));
            return report;
        }).collect(Collectors.toList());
    }
}
