package org.erp.school.service.repository;

import org.erp.school.model.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<ClientRequest, Long> {
}
