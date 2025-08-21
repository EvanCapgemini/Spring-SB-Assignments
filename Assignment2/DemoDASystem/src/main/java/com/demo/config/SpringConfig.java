package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.demo.service", "com.demo.repository" })
public class SpringConfig {
    // No @Bean methods needed for this assignment
}
