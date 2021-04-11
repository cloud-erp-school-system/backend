package org.erp.school.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.erp.school.model.ClientRequest;
import org.erp.school.model.requests.RequestStatus;
import org.erp.school.model.requests.RequestSummary;
import org.erp.school.service.RequestService;
import org.erp.school.service.repository.RequestRepository;

public class RequestServiceImpl implements RequestService {
	
	private RequestRepository requestRepository;
	
	public RequestSummary getRequestSummary() {
		
		RequestSummary requestSummary = new RequestSummary();
		HashMap<RequestStatus, Integer> requestsByStatus = new HashMap<RequestStatus, Integer>();
		
		List<ClientRequest> allClientRequests = requestRepository.findAll();
		Integer totalRequestsReceived = allClientRequests.size();
		List<RequestStatus> requestStatus = Arrays.asList(RequestStatus.values());
		requestStatus.forEach(status -> requestsByStatus.put(status, 0));
		if(totalRequestsReceived > 0) {
			requestStatus.stream().map(status -> requestsByStatus.put(status, Math.toIntExact(allClientRequests.stream().filter(request -> request.getStatus().equals(status)).count())));
		}
		
		//new proposals by day - TO DO
		
		requestSummary.setTotalRequestsReceived(totalRequestsReceived);
		requestSummary.setRequestsByStatus(requestsByStatus);
		return requestSummary;
	}

}
