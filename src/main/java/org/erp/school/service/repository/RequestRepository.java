package org.erp.school.service.repository;

import java.util.List;

import org.erp.school.model.ClientRequest;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<ClientRequest, Long> {
	
	List<ClientRequest> findAll();

}
