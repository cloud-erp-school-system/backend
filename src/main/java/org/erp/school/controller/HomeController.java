package org.erp.school.controller;

import io.swagger.annotations.Api;
import org.erp.school.model.Customer;
import org.erp.school.service.repository.CustomerRepository;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@Api
public class HomeController {

    private final CustomerRepository repository;

    public HomeController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/helloController")
    @ResponseBody
    public String greeting(Principal principal) {
        repository.deleteAll();
        repository.save(new Customer("Alice", "Smith"));
    return "Hello, World,\n" + ((KeycloakAuthenticationToken) principal).getAccount().getKeycloakSecurityContext().getTokenString();
    }
}
