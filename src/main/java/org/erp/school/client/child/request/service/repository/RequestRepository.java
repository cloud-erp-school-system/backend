package org.erp.school.client.child.request.service.repository;

import org.erp.school.client.child.request.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<ClientRequest, Long> {
}