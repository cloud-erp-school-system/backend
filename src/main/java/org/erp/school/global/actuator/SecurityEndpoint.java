package org.erp.school.global.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "security-status")
@Profile("staging")
public class SecurityEndpoint {
    @ReadOperation
    @PreAuthorize("isAuthenticated()")
    public String up(){
        return "secured";
    }
}
