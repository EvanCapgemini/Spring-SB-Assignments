package com.insurance.validator;

import com.insurance.model.PolicyDTO;
import com.insurance.exception.InsuranceException;

import java.time.LocalDate;

public class Validator {

    public static final String INVALID_POLICY_NUMBER = "Policy number is invalid.";
    public static final String INVALID_HOLDER_NAME = "Policy holder name is invalid.";
    public static final String INVALID_DOB = "Date of birth is invalid.";
    public static final String INVALID_POLICY_NAME = "Policy name is invalid.";
    public static final String INVALID_POLICY_TYPE = "Policy type is invalid.";
    public static final String INVALID_PREMIUM = "Premium is invalid.";
    public static final String INVALID_TENURE = "Tenure is invalid.";

    public static void validate(PolicyDTO policy) throws InsuranceException {
        if (!validatePolicyNumber(policy.getPolicyNumber(), policy.getPolicyType()))
            throw new InsuranceException(INVALID_POLICY_NUMBER);
        if (!validatePolicyHolderName(policy.getPolicyHolderName()))
            throw new InsuranceException(INVALID_HOLDER_NAME);
        if (!validateDateOfBirth(policy.getDateOfBirth()))
            throw new InsuranceException(INVALID_DOB);
        if (!validatePolicyName(policy.getPolicyName()))
            throw new InsuranceException(INVALID_POLICY_NAME);
        if (!validatePolicyType(policy.getPolicyType()))
            throw new InsuranceException(INVALID_POLICY_TYPE);
        if (!validatePremium(policy.getPremium()))
            throw new InsuranceException(INVALID_PREMIUM);
        if (!validateTenure(policy.getTenureInMonths()))
            throw new InsuranceException(INVALID_TENURE);
    }

    public static boolean validatePolicyName(String policyName) {
        return policyName != null && policyName.matches("[A-Za-z]+");
    }

    public static boolean validatePolicyType(String policyType) {
        return policyType != null && (
            policyType.equals("Term Life Insurance") ||
            policyType.equals("Whole Life Policy") ||
            policyType.equals("Endowment Plans")
        );
    }

    public static boolean validatePremium(Double premium) {
        return premium != null && premium > 100;
    }

    public static boolean validateTenure(Integer tenureInMonths) {
        return tenureInMonths != null && tenureInMonths > 24;
    }

    public static boolean validateDateOfBirth(LocalDate dateOfBirth) {
        return dateOfBirth != null && dateOfBirth.isBefore(LocalDate.now());
    }

    public static boolean validatePolicyNumber(String policyNumber, String policyType) {
        if (policyNumber == null || policyType == null) return false;

        String acronym = switch (policyType) {
            case "Term Life Insurance" -> "TL";
            case "Whole Life Policy" -> "WL";
            case "Endowment Plans" -> "EP";
            default -> null;
        };

        if (acronym == null) return false;

        return policyNumber.matches(acronym + "-\\d{6}");
    }

    public static boolean validatePolicyHolderName(String policyHolderName) {
        if (policyHolderName == null || policyHolderName.trim().isEmpty()) return false;

        String[] words = policyHolderName.trim().split(" ");
        for (String word : words) {
            if (word.length() >= 3) return true;
        }
        return false;
    }
}
