package org.erp.school.controller;

import org.erp.school.model.Customer;
import org.erp.school.service.repository.CustomerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

  private final CustomerRepository repository;

  public HomeController(CustomerRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/helloController")
  @PreAuthorize("isAuthenticated()")
  @ResponseBody
  public String greeting(Principal principal) {
    repository.deleteAll();
    repository.save(new Customer("Alice", "Smith"));
    return "Hello, World,\n" + principal;
  }
}
