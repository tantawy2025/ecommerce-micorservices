package com.example.order_service.commons.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // in order for the auditing fields to be populated automatically, you need to enable JPA auditing in your Spring application.
public class JpaConfig {
}
