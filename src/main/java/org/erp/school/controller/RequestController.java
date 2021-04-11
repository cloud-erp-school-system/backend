package org.erp.school.controller;

import org.erp.school.model.requests.RequestSummary;
import org.erp.school.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	
    @GetMapping("/client/request/summary")
    @ResponseBody
    public RequestSummary getRequestSummary() {
    	return requestService.getRequestSummary();
    }

}
