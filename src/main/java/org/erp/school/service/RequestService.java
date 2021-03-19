package org.erp.school.service;

import java.util.List;

import org.erp.school.model.ClientRequest;
import org.erp.school.service.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
	
	@Autowired
	private RequestRepository requestRepository;
	
    public List<ClientRequest> getRequests() {
        return requestRepository.findAll();
    }

}
