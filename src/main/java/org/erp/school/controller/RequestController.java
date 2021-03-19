package org.erp.school.controller;
import java.util.List;

import org.erp.school.model.ClientRequest;
import org.erp.school.service.GreetingService;
import org.erp.school.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	
    @GetMapping("/client/requests/summary")
    @ResponseBody
    public String getRequestsSummary() {
    	//TO DO
    	return "String";
    }
    
    @GetMapping("/client/requests")
    @ResponseBody
    public List<ClientRequest> getRequests() {
    	return requestService.getRequests();
    }

}
