package org.erp.school.controller;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@Api
public class HomeController {

  @RequestMapping("/helloController")
  @PreAuthorize("isAuthenticated()")
  @ResponseBody
  public String greeting(Principal principal) {
    return String.format("Hello, %s", getAuthenticatedName(principal));
  }

  private String getAuthenticatedName(Principal principal) {
    return principal == null ? "Developer" : principal.getName();
  }
}
