package org.erp.school.client.child.request.controller;

import org.erp.school.client.child.request.dto.RequestSummaryDto;
import org.erp.school.client.child.request.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/client/request/summary")
    @ResponseBody
    public RequestSummaryDto getRequestSummary() {
        return requestService.getRequestSummary();
    }
}
