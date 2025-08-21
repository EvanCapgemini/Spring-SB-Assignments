package com.insurance.model;

public class PolicyReportDTO {
    private String policyNumber;
    private String policyHolderName;
    private Double policyHolderAge;
    private Integer tenureInMonths;

    public PolicyReportDTO() {
    }

    public PolicyReportDTO(String policyNumber, String policyHolderName, Double policyHolderAge, Integer tenureInMonths) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.policyHolderAge = policyHolderAge;
        this.tenureInMonths = tenureInMonths;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public Double getPolicyHolderAge() {
        return policyHolderAge;
    }

    public void setPolicyHolderAge(Double policyHolderAge) {
        this.policyHolderAge = policyHolderAge;
    }

    public Integer getTenureInMonths() {
        return tenureInMonths;
    }

    public void setTenureInMonths(Integer tenureInMonths) {
        this.tenureInMonths = tenureInMonths;
    }

    @Override
    public String toString() {
        return "PolicyReportDTO [policyNumber=" + policyNumber +
               ", policyHolderName=" + policyHolderName +
               ", policyHolderAge=" + policyHolderAge +
               ", tenureInMonths=" + tenureInMonths + "]";
    }
}
