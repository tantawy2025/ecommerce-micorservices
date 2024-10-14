package com.example.order_service.commons.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Logic to retrieve the current user from the security context
        return Optional.of("current_user"); // Replace with actual user retrieval logic
    }
}
