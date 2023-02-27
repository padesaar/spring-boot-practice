package com.sda.study.springbootpractice.handlers;

import com.sda.study.springbootpractice.utlis.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 *
 * To set the values for the auditing
 */
public class AuditAwareHandler implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}
