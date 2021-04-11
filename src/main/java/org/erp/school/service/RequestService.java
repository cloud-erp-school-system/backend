package org.erp.school.service;

import org.erp.school.model.requests.RequestSummary;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {
	
	RequestSummary getRequestSummary();
}