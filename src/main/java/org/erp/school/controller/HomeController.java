package org.erp.school.controller;

import org.erp.school.model.Customer;
import org.erp.school.service.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final CustomerRepository repository;

    public HomeController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/helloController")
    @ResponseBody
    public String greeting() {
        repository.deleteAll();
        repository.save(new Customer("Alice", "Smith"));
        return "Hello, World";
    }
}
