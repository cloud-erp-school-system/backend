package org.erp.school.client.child.request.repository;

import org.erp.school.client.child.request.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<ClientRequest, String> {
}
