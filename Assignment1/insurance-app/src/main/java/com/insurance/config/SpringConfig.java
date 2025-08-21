package com.insurance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.insurance.repository.InsuranceRepositoryImpl;
import com.insurance.service.InsuranceServiceImpl;

@Configuration
public class SpringConfig {

    @Bean
    public InsuranceRepositoryImpl insuranceRepository() {
        return new InsuranceRepositoryImpl();
    }

    @Bean
    public InsuranceServiceImpl insuranceService() {
        return new InsuranceServiceImpl(insuranceRepository());
    }
}
