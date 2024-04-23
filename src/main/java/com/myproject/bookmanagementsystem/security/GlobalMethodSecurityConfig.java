package com.myproject.bookmanagementsystem.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableMethodSecurity
public class GlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}
