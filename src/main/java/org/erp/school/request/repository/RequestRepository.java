package org.erp.school.request.repository;

import org.erp.school.request.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<ClientRequest, String> {
}
