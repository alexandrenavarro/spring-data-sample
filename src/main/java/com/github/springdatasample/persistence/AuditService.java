package com.github.springdatasample.persistence;

import org.springframework.data.domain.AuditorAware;

public class AuditService implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "user";
    }

}
