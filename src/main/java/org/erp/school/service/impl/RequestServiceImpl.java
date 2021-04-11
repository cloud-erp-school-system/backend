package org.erp.school.service.impl;

import org.erp.school.model.requests.RequestSummary;
import org.erp.school.service.RequestService;
import org.erp.school.service.repository.RequestRepository;

public class RequestServiceImpl implements RequestService {
	
	private RequestRepository requestRepository;
	
	public RequestSummary getRequestSummary() {
		//TO DO
		return new RequestSummary();
	}

}
