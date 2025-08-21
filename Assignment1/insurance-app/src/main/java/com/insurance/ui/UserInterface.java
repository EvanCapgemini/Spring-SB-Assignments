package com.insurance.ui;

import com.insurance.config.SpringConfig;
import com.insurance.model.PolicyDTO;
import com.insurance.service.InsuranceServiceImpl;
import com.insurance.exception.InsuranceException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.time.LocalDate;

public class UserInterface {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        InsuranceServiceImpl service = context.getBean(InsuranceServiceImpl.class);

        PolicyDTO policy = new PolicyDTO();
        policy.setPolicyNumber("WL-553912");
        policy.setPolicyHolderName("James");
        policy.setDateOfBirth(LocalDate.of(1992, 1, 10));
        policy.setPolicyName("Retirement");
        policy.setPolicyType("Whole Life Policy");
        policy.setPremium(3500.0);
        policy.setTenureInMonths(180);

        try {
            String result = service.buyPolicy(policy);
            System.out.println(result);
        } catch (InsuranceException e) {
            System.out.println(e.getMessage());
        }

        context.close();
    }
}
